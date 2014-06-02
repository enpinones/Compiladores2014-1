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
			return "MISSING :C";
		}
    }
}
