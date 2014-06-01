package analysis.ASTNode;
import java.util.*;
import analysis.*;
public class TransfNode extends Node
{
    private String id1;
    private String id2;

    public TransfNode(String id1, String id2)
    {
	this.id1 = id1;
	this.id2 = id2;
    }
    public String getId1()
    {
	return this.id1;
    }
    public String getId2()
    {
	return this.id2;
    }
    public String toString()
    {
	return id1 + " --> " + id2;
    }
}
