package analysis.ASTNode;
import analysis.*;
public class UnaryNode extends Node
{
    private String op;

    public UnaryNode(String op)
    {
	this.op = op;
    }

    public String toString()
    {
	return "unary "+op;
    }
}
