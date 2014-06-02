package analysis.ASTNode;
import java.util.Arrays;
import java.util.List;

import analysis.*;
public class UnaryNode extends Node
{
    private String op;
    List<String> boolOperators;

    public UnaryNode(String op)
    {
    	this.op = op;
    	boolOperators = Arrays.asList("~");
    }

    public String toString()
    {
    	return "unary "+op+" <"+GetOperatorType()+">";
    }
    
    public String GetOperatorType()
    {
    	
		if(boolOperators.contains(op))
		{
			return "BOOL";
		}
		else
		{
			return "MISSING :C";
		}
    }
    
}
