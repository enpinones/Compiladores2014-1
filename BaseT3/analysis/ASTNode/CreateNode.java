package analysis.ASTNode;
import analysis.*;
public class CreateNode extends Node
{
    private String type;

    public CreateNode(String type)
    {
	this.type = type;
    }

    public String toString()
    {
	return "create "+type;
    }
}
