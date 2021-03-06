package analysis.ASTNode;
import java.util.*;
import analysis.*;

public class LiteralNode extends Node
{
    private String type;
    private String value;


    public LiteralNode(String type, String value)
    {
	this.type = type;
	this.value = value;
    }

    public String toString()
    {
    	return "literal "+type+" "+value+" <"+GetType()+">";
    }
    public String GetType()
    {
    	if(type.equals("STR"))
    	{
    		return "STRING";
    	}
    	return type;
    }
}
