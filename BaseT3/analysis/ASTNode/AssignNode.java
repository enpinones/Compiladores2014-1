package analysis.ASTNode;
import java.util.*;
import analysis.*;
public class AssignNode extends Node
{
    private String type;
    private String id;

    public String getType()
    {
	return this.type;
    }
    public String getId()
    {
	return this.id;
    }
    public AssignNode(String id, String type)
    {
	this.type = type;
	this.id = id;
    }

    public AssignNode(String id)
    {
	this.type = null;
	this.id = id;
    }

    public AssignNode()
    {
	this.type = null;
	this.id = null;
    }

    public String toString()
    {
	if(type != null && id != null) {
	    return "assign "+id + ":" + type;
	}
	if (id != null) {
	    return "assign "+id;
	}
	return "assign";
    }
}
