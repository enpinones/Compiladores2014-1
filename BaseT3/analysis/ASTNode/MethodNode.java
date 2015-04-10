package analysis.ASTNode;
import java.util.*;
import analysis.*;
public class MethodNode extends Node
{
    private String name;
    private String retType;
    private boolean priv;

    public MethodNode(String name, String type)
    {
	this.name = name;
	this.retType = type;
	this.priv = false;
    }
    public void setPrivate()
    {
	this.priv = true;
    }
    public String getName()
    {
	return this.name;
    }
    public String getType()
    {
	return this.retType;
    }
    public boolean getPriv()
    {
	return this.priv;
    }
    public String toString()
    {
	String ret;
	if(this.priv) {
	    ret = "method private "+name;
	}
	else {
	    ret =  "method "+name;
	}
	if(this.retType != null) {
	    ret += " : "+retType;
	}
	return ret;
    }
}
