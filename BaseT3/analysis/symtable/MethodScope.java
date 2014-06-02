package analysis.symtable;
import analysis.*;

public class MethodScope extends Node
{
    public String name;
    public Method method;
    private SClass sclass;

    public MethodScope(String name, Method method)
    {
	super();
	this.name = name;
	this.method = method;
    }
    public Method getMethod()
    {
	return this.method;
    }
    public String toString()
    {
	return "Method: " + name + " : " + method.retType;
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
