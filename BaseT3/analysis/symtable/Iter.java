package analysis.symtable;
import java.util.*;

public class Iter
{
    public boolean isPrivate;
    public String name;
    public String retType;
    public ArrayList<Variable> args;

    public Iter(String name, String rType, boolean isPrivate)
    {
	this.name = name;
	this.retType = rType;
	this.isPrivate = isPrivate;
	args = new ArrayList<Variable>();
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
}
