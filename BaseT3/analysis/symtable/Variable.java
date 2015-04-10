package analysis.symtable;

public class Variable
{
    public boolean isPrivate;
    public String name;
    public String type;
    public boolean isOnce;

    public Variable(String name, String type, boolean isPrivate, boolean isOnce)
    {
	this.name = name;
	this.type = type;
	this.isPrivate = isPrivate;
	this.isOnce = isOnce;
    }
    public Variable(String name, String type, boolean isPrivate)
    {
	this(name,type,isPrivate,false);
    }

    public Variable(String name, String type)
    {
	this(name, type, false);
    }
    public String getType()
    {
	return this.type;
    }
    public String getName()
    {
	return this.name;
    }
    public void setOnce()
    {
	this.isOnce = true;
    }
}
