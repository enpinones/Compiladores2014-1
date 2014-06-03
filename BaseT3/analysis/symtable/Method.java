package analysis.symtable;
import java.util.*;

public class Method
{
    public boolean isPrivate;
    public String name;
    public String retType;
    public ArrayList<Variable> args;
    private SClass sclass;

    public Method(String name, String rType, boolean isPrivate)
    {
	this.name = name;
	this.retType = rType;
	this.isPrivate = isPrivate;
	args = new ArrayList<Variable>();
    }
    public Method(String name, String rType)
    {
	this(name, rType, false);
    }
    public void addArg(String name, Variable var)
    {
	this.args.add(var);
    }
    public Variable getArg(String name)
    {
	for(Variable var : args) {
	    if(var.name.equals(name)) {
		return var;
	    }
	}
	return null;
    }
    public int argCount ()
    {
	return this.args.size();
    }
    public void setSclass(SClass sclass)
    {
    	this.sclass = sclass;
    }
    public SClass getSclass(SClass sclass)
    {
    	return sclass;
    }
    public String GetRetType()
    {
    	return retType;
    }
}
