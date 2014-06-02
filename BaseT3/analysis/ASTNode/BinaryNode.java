package analysis.ASTNode;
import java.util.*;

import analysis.*;
public class BinaryNode extends Node
{
    private String op;
    List<String> intOperators;
    List<String> boolOperators;

    public BinaryNode(String op)
    {
    	this.op = op;
    	intOperators = Arrays.asList("+","-","*","/","%");
    	boolOperators = Arrays.asList("<",">","=","!");
    }
    public String getOp()
    {
	return this.op;
    }
    public String toString()
    {
    	return "binary "+op+" <"+GetOperatorType()+">";
    }
    
    public String GetOperatorType()
    {
    	//Buscamos la operación más pequeña que no sea bool y que sea create o literal (que sea hija)
    	Node importantNode = this;
    	while(importantNode.leftChild() != null)
    	{
    		importantNode=importantNode.leftChild();
//    		if(importantNode instanceof LiteralNode)
//    		{
//    			LiteralNode ln = (LiteralNode)importantNode;
//    			return ln.GetType();
//    		}
    		if(importantNode instanceof CreateNode)
    		{
    			CreateNode cn = (CreateNode)importantNode;
    			return cn.getType();
    		}
    	
    		
    	}
		if(intOperators.contains(op))
		{
			return "INT";
		}
		else if(boolOperators.contains(op))
		{
			return "BOOL";
		}
		else
		{
			return "INVALID";
		}
    }
}
