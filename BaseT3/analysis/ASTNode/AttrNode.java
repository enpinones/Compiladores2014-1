package analysis.ASTNode;
import analysis.*;
import java.util.*;

public class AttrNode extends Node
{
    private String name;
    private String type;
    private boolean priv;

    public String getName()
    {
	return this.name;
    }
    public String getType()
    {
	return this.type;
    }
    public boolean getPriv()
    {
	return this.priv;
    }
    public AttrNode(String name, String type)
    {
	this.name = name;
	this.type = type;
	this.priv = false;
    }
    public void setPrivate()
    {
	this.priv = true;
    }
    public String toString()
    {
	if(priv) {
	    return "attr private "+name+":"+type;
	}
	return "attr "+name+":"+type;
    }
}
