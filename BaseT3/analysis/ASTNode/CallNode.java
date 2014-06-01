package analysis.ASTNode;
import analysis.*;
public class CallNode extends Node
{
    private String id;

    public CallNode(String id)
    {
	this.id = id;
    }

    public String toString()
    {
	return "call "+id;
    }
}
