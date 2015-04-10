package analysis.symtable;
import analysis.*;
import java.util.*;
public class VarScope extends Node
{
    public HashMap<String, Variable> vars;

    public VarScope()
    {
	this.vars = new HashMap<String, Variable>();
    }

    public void addVariable(Variable v)
    {
	this.vars.put(v.name, v);
    }
    public Variable getVar(String id)
    {
	return this.vars.get(id);
    }
    public String toString() 
    {
	String ret = "vars: ";
	for(Variable v : vars.values()) {
	    ret += v.name+":" + v.type+ ",";
	}
	return ret;
    }
}
