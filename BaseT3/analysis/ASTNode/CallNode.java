package analysis.ASTNode;
import analysis.*;
import analysis.symtable.Method;
import analysis.symtable.MethodScope;
import analysis.symtable.VarScope;
import analysis.symtable.Variable;
public class CallNode extends Node
{
	private String id;

	public CallNode(String id)
	{
		this.id = id;
	}

	public String toString()
	{
		String opType = GetType();
    	if(opType.equals("INVALID"))
    		return "call "+id+" "+opType;
		return "call "+id+" <"+opType+">";
	}

	public String GetType()
	{
		//Buscamos en el method scope por el type de id
		Node importantNode = this;
		if(importantNode.getScope().getParent() instanceof MethodScope)
		{
			//Sacamos el scope
			MethodScope ms = (MethodScope)(importantNode.getScope().getParent());
			//Revisamos la superclass para ver si está el tipo del id actual
			Variable var = ms.getSclass().attrs.get(id);
			if(var != null)
			{
				//Si tiene devolvemos
				return var.type;
			}
			//Además revisamos sies una llamada a metodo
			MethodScope ms2 = ms.getSclass().methods.get(id);
			if(ms2 != null)
			{
				Method met = ms2.method;
				if(met != null)
					return met.GetRetType();
			}
			
		}
		//Sino buscamos en el scope mismo
		importantNode = this;
		if(importantNode.getScope() instanceof MethodScope)
		{
			MethodScope ms = (MethodScope)(importantNode.getScope());
			//Revisamos la superclass para ver si está el tipo del id actual
			Variable var = ms.getSclass().attrs.get(id);
			if(var != null)
			{
				//Si tiene devolvemos
				return var.type;
			}
		}
		//Buscamos para casos especiales
		importantNode = this;
		if(importantNode.rightBrotherp())
		{
			importantNode = importantNode.rightBrother();
			MethodScope ms = null;
			if(importantNode.getScope() != null && importantNode.getScope().getParent() != null && importantNode.getScope().getParent() instanceof MethodScope)
				ms = (MethodScope) importantNode.getScope().getParent();
			if(importantNode instanceof LiteralNode)
			{
				LiteralNode ln = (LiteralNode)importantNode;
				//Actualizamos scope
				Variable var = new Variable(id, ln.GetType(), false, false);
				ms.getSclass().attrs.put(id, var);
				return ln.GetType();
			}
		}
		
		
		return "INVALID";
	}
}
