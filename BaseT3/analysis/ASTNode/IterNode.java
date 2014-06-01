package analysis.ASTNode;
import analysis.*;
public class IterNode extends Node
{
    private String name;
    private String retType;
    private boolean priv;


    public IterNode(String name, String type)
    {
	this.name = name;
	this.retType = type;
	this.priv = false;
    }

    public IterNode(String name)
    {
	this.name = name;
	this.retType = null;
	this.priv = false;
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
    public void setPrivate()
    {
	this.priv = true;
    }

    public String toString()
    {
	String val;
	if(priv) {
	    val = "iterator private "+name;
	}
	val =  "iterator "+name;
	if(this.retType != null){
	    val += " : " + retType;
	}
	return val;
    }
}
