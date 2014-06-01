package analysis.symtable;
import analysis.*;

public class IterScope extends Node
{
    public String name;
    public Iter iter;

    public IterScope(String name, Iter iter)
    {
	super();
	this.name = name;
	this.iter = iter;
    }
    public Iter getIter() 
    {
	return this.iter;
    }
    public String toString()
    {
	return "iter: "+name + " : " + iter.retType;
    }
}
