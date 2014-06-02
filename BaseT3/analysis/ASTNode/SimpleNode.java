package analysis.ASTNode;
import java.util.Arrays;
import java.util.List;

import analysis.*;
import analysis.symtable.MethodScope;
import analysis.symtable.VarScope;
public class SimpleNode extends Node
{
    private String label;
    List<String> boolOperators;

    public SimpleNode(String lbl)
    {
    	this.label = lbl;
    	boolOperators = Arrays.asList("or","and");
    }
    public String getLabel()
    {
	return this.label;
    }
    public String toString()
    {
	return "" + this.label +""+GetOperatorType();
    }
    
    public String GetType()
    {
    	String result = GetOperatorType();
    	result = result.replace('<', ' ');
    	result = result.replace('>', ' ');
    	result = result.trim();
    	return result;
    }
    
    public String GetOperatorType()
    {
    	
		if(boolOperators.contains(label))
		{
			return " <BOOL>";
		}
		//Buscamos en el scope
		else if(label.equals("new") || label.equals("self"))
		{
			Node importantNode = this;
			//System.out.println(importantNode.getScope().getParent().getClass());
		    if(importantNode.getScope().getParent() instanceof MethodScope)
		    {
		    	MethodScope ms = (MethodScope)importantNode.getScope().getParent();
		    	return " <"+ms.getSclass().name+">";
		    }
		    else if(importantNode.getScope() instanceof MethodScope)
		    {
		    	MethodScope ms = (MethodScope)importantNode.getScope();
		    	return " <"+ms.getSclass().name+">";
		    }
		}
		else if(this.getParent()!=null && !(this.getParent() instanceof MethodNode) && (this.leftChild() instanceof LocalNode))
		{
			Node importantNode = this;
			if(importantNode.getScope() instanceof MethodScope)
			{
				MethodScope ms = (MethodScope)importantNode.getScope();
				return " <"+ms.getMethod().retType+">";
			}
		}
		
		return "";
    }

}
