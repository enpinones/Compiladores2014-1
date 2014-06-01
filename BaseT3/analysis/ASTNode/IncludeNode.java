package analysis.ASTNode;
import java.util.*;
import analysis.*;
public class IncludeNode extends Node
{
    private String id;

    public String getId()
    {
	return this.id;
    }

    public IncludeNode(String id)
    {
	this.id = id;
    }

    public String toString()
    {
	return "include "+id;
    }
}
