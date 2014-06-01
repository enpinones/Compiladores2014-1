package analysis.symtable;
import analysis.*;
import java.util.HashMap;
import java.util.ArrayList;

public class SClass extends Node
{
    public String name;
    public ArrayList<String> supertypes;
    public HashMap<String, Variable> attrs;
    public HashMap<String, MethodScope> methods;
    public HashMap<String, IterScope> iterators;
    private HashMap<String, classInclusion> incl;
    private ArrayList<String> included;

    public SClass(String name)
    {
	this.name = name;
	this.attrs = new HashMap<String, Variable>();
	this.methods = new HashMap<String, MethodScope>();
	this.iterators = new HashMap<String, IterScope>();
	this.supertypes = new ArrayList<String>();
	this.included = new ArrayList<String>();
	this.incl = new HashMap<String, classInclusion>();
    }
    public void addInclusion(String name) 
    {
	this.included.add(name);
	this.incl.put(name,new classInclusion(name));
    }
    public void addTransform(String className, String src, String tar)
    {
	this.incl.get(className).addTransform(src,tar);
    }
    public String getTransfId (String className, String src)
    {
	return this.incl.get(className).getTarget(src);
    }
    public boolean checkInclusion (String clName)
    {
	return incl.get(clName) != null;
    }
    public ArrayList<String> getIncluded()
    {
	return this.included;
    }
    public String toString()
    {
	return "met: "+methods.size()+ "attr: "+ attrs.size()+"iters: "+ iterators.size();
    }
}

class classInclusion
{
    private String other;
    private HashMap<String,String> transf;

    public classInclusion(String other) {
	this.other = other;
	this.transf = new HashMap<String,String>();
    }
    public void addTransform (String src, String target)
    {
	this.transf.put(src,target);
    }

    public String getTarget(String src) 
    {
	String t = this.transf.get(src);
	if (t != null) {
	    return t;
	}
	return src;
    }
}
