package analysis.ASTNode;
import java.util.*;
import analysis.*;

public class DeclNode extends Node
{
    private String type;
    private String id;

    public DeclNode(String id, String type)
    {
	this.type = type;
	this.id = id;
    }
    public String getType()
    {
	return this.type;
    }
    public String getId()
    {
	return this.id;
    }
    public String toString()
    {
	return "decl "+id + ":" + type;
    }
}
