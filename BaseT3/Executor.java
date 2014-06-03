import java.io.*;
import analysis.*;
import analysis.ASTNode.*;
import analysis.symtable.*;

public class Executor
{
	
	
    public void scan(String fname)
    {
	try {
	    File f = new File(fname);
	    Reader r = new FileReader(f);
	    Scanner s = new Scanner(r);
	    int value;
	    

	    while((value = s.yylex()) != Parser.EOF) {
		if (value == Parser.CHAR) {
		    System.out.printf("%d(%d,%d):char:%s\n", s.beginChar, s.getLine(), s.beginCol, s.getPrintableString());
		}
		else if (value == Parser.STRING) {
		    System.out.printf("%d(%d,%d):string[%d]:%s\n", s.beginChar, s.beginLine, s.beginCol, s.getStrlen(), s.getPrintableString());
		}
		else if (value == Parser.BOOL) {
		    System.out.printf("%d(%d,%d):bool:%s\n", s.getChar(), s.getLine(), s.getColumn(), s.getLVal());
		}
		else if (value == Parser.INT) {
		    System.out.printf("%d(%d,%d):integer:%s\n", s.getChar(), s.getLine(), s.getColumn(), s.getLVal());
		}
		else if (value == Parser.UPCASE_ID) {
		    System.out.printf("%d(%d,%d):uppercase_identifier:%s\n", s.getChar(), s.getLine(), s.getColumn(), s.getLVal());
		}
		else if (value == Parser.ID) {
		    System.out.printf("%d(%d,%d):identifier:%s\n", s.getChar(), s.getLine(), s.getColumn(), s.getLVal());
		}
		else if (value == Parser.ITER_NAME) {
		    System.out.printf("%d(%d,%d):iter_name:%s\n", s.getChar(), s.getLine(), s.getColumn(), s.getLVal());
		}
		else if (value == Parser.ERROR) {
		    System.out.printf("LEXICAL_ERROR(%d,%d)\n", s.getLine(), s.getColumn());
		    break;
		}
		else if(s.isSymbol()) {
		    System.out.printf("%d(%d,%d):symbol:%s\n", s.getChar(), s.getLine(), s.getColumn(), s.getPrintableString());
		}
		else if (s.isKeyword()) {
		    System.out.printf("%d(%d,%d):keyword:%s\n", s.getChar(), s.getLine(), s.getColumn(), s.getPrintableString());
		}
	    }
	}catch(FileNotFoundException fnf){
	    System.err.println("file " + fname + " not found");
	}catch(IOException i){
	    System.err.println("io exception");
	}
    }

    public ASTree parse(String fname)
    {
	File f;
	Reader r;
	Scanner lex;
	Parser par;
	int value, lineno;
	ASTree ast = null;
	Symtable stable = null;

	try{
	    f = new File(fname);
	    r = new FileReader(f);
	    lex = new Scanner(r);
	    par = new Parser(lex);
	    if(!par.parse()) {
		return null;
	    }

	    ast = par.getAST();
	    stable = new Symtable(ast);
	    
	}catch(FileNotFoundException fnf){
	    System.err.print("file not found\n");
	}catch(IOException i){
	    System.err.print("io exception\n");
	}
	return ast;
    }

    public void findExample (String path)
    {
	ASTree tree = parse(path);
	Symtable stable = new Symtable(tree);
	
	Node bin = findBinary(tree.getRoot(), "%");
	Node sc = bin.getScope();
	Variable var = stable.findVariableFromScope(sc, "x");
	System.out.printf("vartype: %s\n", var.getType());
    }

    public void includeExample (String path)
    {
	ASTree tree = parse(path);
	Symtable stable = new Symtable(tree);
	stable.includeClass("C", "E");
	Variable var = stable.findAttr("E", "yC");
	System.out.printf("attr type: %s\n", var.getType());
    }

    public Node findBinary (Node astNode, String op) {
	Node aux, ret;
	if (astNode == null) {
	    return null;
	}
	
	if(astNode instanceof analysis.ASTNode.BinaryNode && 
	   ((BinaryNode)astNode).getOp().equals(op)) {
	    return astNode;
	}
	aux = astNode.leftChild();
	while (aux != null) {
	    if((ret = findBinary(aux,op)) != null) {
		return ret;
	    }
	    aux = aux.rightBrother();
	}
	return null;
    }
}
