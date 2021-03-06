package analysis.ASTNode;
import java.util.*;
import analysis.*;
import analysis.symtable.SClass;
public class MethodNode extends Node
{
    private String name;
    private String retType;
    private boolean priv;
    private SClass sclass;

    public MethodNode(String name, String type)
    {
	this.name = name;
	this.retType = type;
	this.priv = false;
    }
    public void setSclass(SClass sclass)
    {
    	this.sclass = sclass;
    }
    public SClass getSclass(SClass sclass)
    {
    	return sclass;
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
