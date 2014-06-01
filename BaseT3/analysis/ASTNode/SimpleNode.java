package analysis.ASTNode;
import analysis.*;
public class SimpleNode extends Node
{
    private String label;

    public SimpleNode(String lbl)
    {
	this.label = lbl;
    }
    public String getLabel()
    {
	return this.label;
    }
    public String toString()
    {
	return "" + this.label;
    }

}
