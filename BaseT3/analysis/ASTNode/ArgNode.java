package analysis.ASTNode;
import java.util.*;
import analysis.*;

public class ArgNode extends Node
{
    private String type;
    private String id;
    private boolean once;
    
    public ArgNode(String id, String type)
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
    public boolean getOnce()
    {
	return this.once;
    }
    public void setOnce()
    {
	this.once = true;
    }

    public String toString()
    {
	if(!once) {
	    return id + ":" + type;
	}
	return id + ":" + type + " once";
    }
}
