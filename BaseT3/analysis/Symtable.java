package analysis;

import java.util.*;
import analysis.ASTNode.*;
import analysis.symtable.*;
import analysis.LabeledDiGraph;

public class Symtable
{
    private HashMap<String, SClass> classes;
    private LabeledDiGraph subtypes;
    private ArrayList<String> classList;

    public Symtable()
    {
	classes = new HashMap<String, SClass>();
	subtypes = null;
    }

    public Symtable(ASTree ast)
    {
	this();
	ClassNode cn = (ClassNode) ast.getRoot().leftChild();
	classList = new ArrayList<String>();
	classList.add("OB");
	classList.add("STR");
	classList.add("STRING");
	classList.add("INT");
	classList.add("BOOL");
	classList.add("CHAR");
	classList.add("IN");
	classList.add("OUT");

	while(cn != null) {
	    classes.put(cn.getName(), makeClassTree(cn));
	    classList.add(cn.getName());
	    cn = (ClassNode) cn.rightBrother();
	}
	subtypes = new LabeledDiGraph(classList);


	SClass clNode;
	for (String cl : classList) {
	    clNode = classes.get(cl);
	    if(clNode != null) {
		for (String sup : clNode.supertypes) {
		    subtypes.addEdge(cl, sup);
		}
	    }
	}
	subtypes.transitiveClosure();
	LabeledDiGraph copy = subtypes.copy();
	if (copy.invTopologicalSort() == null) {
	    System.out.printf("Semantic error: cyclic subtyping\n");
	}
    }

    public void addClass (String name,SClass sc)
    {
	this.classes.put(name, sc);
    }

    public boolean isSubType(String type1, String type2)
    {
	int edge = subtypes.getEdge(type1, type2);
	return edge == 1;
    }

    private SClass makeClassTree(ClassNode cn)
    {
	SClass cl = new SClass(cn.getName());
	Node aux = cn.leftChild();
	cl.supertypes = cn.getSupertypes();

	while(aux != null) {
	    if (aux instanceof analysis.ASTNode.AttrNode) {
		AttrNode an = (AttrNode) aux;
		Variable v = new Variable(an.getName(), an.getType(), an.getPriv());
		cl.attrs.put(an.getName(), v);
	    }
	    else if (aux instanceof analysis.ASTNode.MethodNode) {
		MethodNode mn = (MethodNode) aux;
		MethodScope ms = makeMethodTree(mn);
		cl.methods.put(mn.getName(), ms);
	    }
	    else if (aux instanceof analysis.ASTNode.IterNode) {
		IterNode in = (IterNode) aux;
		IterScope is = makeIteratorTree(in);
		cl.iterators.put(in.getName(), is);
	    }
	    else if (aux instanceof analysis.ASTNode.IncludeNode) {
		String otherClass = ((IncludeNode)aux).getId();
		cl.addInclusion(otherClass);
		if(aux.leftChild() != null) {
		    TransfNode tn = (TransfNode) aux.leftChild();
		    while (tn != null) {
			cl.addTransform(otherClass, tn.getId1(), tn.getId2());
			tn = (TransfNode) tn.rightBrother();
		    }
		}
	    }
	    aux.setScope(cl);
	    aux =  aux.rightBrother();
	}
	return cl;
    }

    private MethodScope makeMethodTree (MethodNode mn)
    {
	Method m = new Method(mn.getName(), mn.getType(), mn.getPriv());
	SimpleNode sn = (SimpleNode) mn.leftChild();
	MethodScope ms = null;
	if(sn.getLabel().equals("arguments")) {
	    ArgNode aux = (ArgNode) mn.leftChild().leftChild();
	    while (aux != null) {
		Variable var = new Variable(aux.getId(), aux.getType());
		m.args.add(var);
		aux = (ArgNode) aux.rightBrother();
	    }
	    ms = new MethodScope(mn.getName(), m);
	    makeSubTree(mn.leftChild().rightBrother(), ms);
	}
	else {
	    ms = new MethodScope(mn.getName(), m);
	    makeSubTree(mn.leftChild(), ms);
	}
	return ms;
    }
    public Method currentMethod (Node scope) 
    {
	Node aux = scope;
	while (aux != null && !(aux instanceof MethodScope)) {
	    aux = aux.getParent();
	}
	if (aux == null) {
	    return null;
	}
	return ((MethodScope)aux).getMethod();
    }

    public Iter currentIter (Node scope) 
    {
	Node aux = scope;
	while (aux != null && !(aux instanceof IterScope)) {
	    aux = aux.getParent();
	}
	if (aux == null) {
	    return null;
	}
	return ((IterScope)aux).iter;
    }

    private IterScope makeIteratorTree(IterNode in)
    {
	Iter it = new Iter(in.getName(), in.getType(), in.getPriv());
	SimpleNode sn = (SimpleNode) in.leftChild();
	if(sn.getLabel().equals("arguments")) {
	    ArgNode aux = (ArgNode) in.leftChild().leftChild();
	    while(aux != null) {
		Variable var = new Variable(aux.getId(), aux.getType(), false, aux.getOnce());
		it.args.add(var);
		aux = (ArgNode) aux.rightBrother();
	    }
	}

	IterScope is = new IterScope(it.name, it);
	makeSubTree(in.leftChild(), is);
	return is;
    }

    private Node makeSubTree(Node n, Node curParent)
    {
	if(n==null) {
	    return null;
	}
	Node aux;
	Node newParent = curParent;
	if (n instanceof analysis.ASTNode.ArgNode) {
	    VarScope vs = new VarScope();
	    aux =  n;
	    while(aux != null && aux instanceof analysis.ASTNode.ArgNode) {
		ArgNode dn = (ArgNode) n;
		Variable nv = new Variable(dn.getId(), dn.getType());
		vs.vars.put(nv.name, nv);
		aux =  aux.rightBrother();
	    }
	    curParent.addChild(vs);
	    newParent = vs;
	}
	else if (n instanceof analysis.ASTNode.AssignNode) {
	    VarScope vs = new VarScope();
	    AssignNode an = (AssignNode) n;
	    if (an.getId() != null) {
		/*
		 * asignacion con declaracion
		 */
		Variable var = new Variable(an.getId(), an.getType());
		vs.addVariable(var);
		curParent.addChild(vs);
		newParent = vs;
	    }
	}
	n.setScope(newParent);

	aux =  n.leftChild();
	Node last = newParent;
	while (aux != null) {
	    last = makeSubTree(aux,last);
	    aux =  aux.rightBrother();
	}
	return last;
    }

    public Variable findVariableInScope (Node sc, String var)
    {
	Variable ret = null;
	if (sc instanceof analysis.symtable.VarScope) {
	    VarScope vs = (VarScope) sc;
	    ret = vs.getVar(var);
	}
	else if (sc instanceof analysis.symtable.MethodScope ) {
	    MethodScope ms = (MethodScope) sc;
	    Method met = ms.getMethod();
	    ret = met.getArg(var);
	}
	else if (sc instanceof analysis.symtable.IterScope ) {
	    IterScope is = (IterScope) sc;
	    ret = is.getIter().getArg(var);
	}
	return ret;
    }

    public Variable findVariableFromScope(Node scope, String var) 
    {
	Variable ret = null;
	if(scope == null) {
	    return null;
	}
	if ((ret = findVariableInScope (scope, var)) != null) {
	    return ret;
	}
	return findVariableFromScope(scope.getParent(), var);
    }

    public Iter findIter (String className, String iterName)
    {
	SClass cl = classes.get(className);
	if (cl== null) {
	    System.out.printf("error: class `%s' not defined\n", className);
	    return null;
	}
	IterScope is = cl.iterators.get(iterName);
	if(is != null) {
	    return is.getIter();
	}
	return null;
    }

    public Method findMethod (String className, String methodName)
    {
	SClass cl = classes.get(className);
	if (cl== null) {
	    System.out.printf("error: class `%s' not defined\n", className);
	    return null;
	}
	MethodScope ms = cl.methods.get(methodName);
	if(ms != null) {
	    return ms.method;
	}
	return null;
    }

    public Variable findAttr (String className, String attrName)
    {
	SClass cl = classes.get(className);
	if (cl== null) {
	    System.out.printf("error: class `%s' not defined\n", className);
	    return null;
	}
	Variable var = cl.attrs.get(attrName);
	return var;
    }

    public void includeClass (String clname1, String clname2)
    {
	SClass cl1 = classes.get(clname1);
	if (cl1== null) {
	    System.out.printf("error: class `%s' not defined\n", clname1);
	    return;
	}
	SClass cl2 = classes.get(clname2);
	if (cl2== null) {
	    System.out.printf("error: class `%s' not defined\n", clname2);
	    return;
	}
	includeClass(cl1,cl2);
    }

    public void includeClass (SClass class1, SClass class2)
    {
	/* incluye class1 en class2 */

	/*
	 * hay que tener cuidado con el orden en que se
	 * ejecuta este método, ya que si A incluye B, y
	 * B incluye C, y se ejecuta includeClass(A,B) antes
	 * de includeClass(B,C), A no incluirá los elementos de
	 * C. 
	 * (hint: orden topológico?)
	 */

	if ( ! class2.checkInclusion(class1.name)) {
	    return;
	}

	for (Map.Entry<String, Variable> atr : class1.attrs.entrySet()) {
	    class2.attrs.put(class2.getTransfId(class1.name, atr.getKey()), 
			     atr.getValue());
	}
	for (Map.Entry<String, MethodScope> met : class1.methods.entrySet()) {
	    class2.methods.put(class2.getTransfId(class1.name, met.getKey()), 
			       met.getValue());
	}
	for (Map.Entry<String, IterScope> iter : class1.iterators.entrySet()) {
	    class2.iterators.put(class2.getTransfId(class1.name, iter.getKey()), 
				 iter.getValue());
	}
    }

    public LabeledDiGraph addClassInclusion ()
    {
	LabeledDiGraph incl = new LabeledDiGraph(classList);
	for (String cl : classList) {
	    SClass clNode = classes.get(cl);
	    for (String inc : clNode.getIncluded()) {
		incl.addEdge(cl, inc);
	    }
	}
	ArrayList<String> order = incl.copy().invTopologicalSort();
	if (order == null) {
	    System.out.printf("Semantic error: cyclic class inclusion\n");
	    return null;
	}
	for (int i=0;i<order.size();i++) {
	    for (int j=i+1;j<order.size();j++) {
		if (incl.getEdge(order.get(j), order.get(i)) == 1) {
		    includeClass(order.get(i), order.get(j));
		}
	    }
	}
	return incl;
    }

    public String toString()
    {
	String ret = "";
	for(SClass cl: classes.values()) {
	    ret += cl.toString() +"\n";
	}
	return ret;
    }
}
