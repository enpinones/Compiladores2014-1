package analysis.symtable;
import analysis.*;
import java.util.*;
public class VarScope extends Node
{
	public HashMap<String, Variable> vars;
	private SClass sclass;

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
	public void setSclass(SClass sclass)
	{
		this.sclass = sclass;
	}
	public SClass getSclass()
	{
		return sclass;
	}
}
