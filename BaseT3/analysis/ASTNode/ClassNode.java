package analysis.ASTNode;
import java.util.*;
import analysis.*;
public class ClassNode extends Node
{
    private String name;
    private ArrayList<String> supertypes;

    public ClassNode(String name)
    {
	this.name = name;
	supertypes = null;
    }
    public ArrayList<String> getSupertypes()
    {
	return this.supertypes;
    }
    public String getName()
    {
	return this.name;
    }
    public void setSuperTypes(ArrayList<String> sup)
    {
	this.supertypes = sup;
    }

    public String toString()
    {
	int i;
	StringBuffer buff;
	if(supertypes == null) {
	    return "class " + name;
	}

	buff = new StringBuffer("class "+name+" :");

	for(i=0;i<supertypes.size();i++) {
	    buff.append(" " + supertypes.get(i));
	}

	return buff.toString();
    }
}
