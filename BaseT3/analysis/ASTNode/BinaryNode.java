package analysis.ASTNode;
import analysis.*;
public class BinaryNode extends Node
{
    private String op;

    public BinaryNode(String op)
    {
	this.op = op;
    }
    public String getOp()
    {
	return this.op;
    }
    public String toString()
    {
	return "binary "+op;
    }
}
