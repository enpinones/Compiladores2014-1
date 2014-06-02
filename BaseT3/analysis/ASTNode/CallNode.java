package analysis.ASTNode;
import analysis.*;
import analysis.symtable.MethodScope;
import analysis.symtable.Variable;
public class CallNode extends Node
{
	private String id;

	public CallNode(String id)
	{
		this.id = id;
	}

	public String toString()
	{
		return "call "+id+" <"+GetType()+">";
	}

	private String GetType()
	{
		//Buscamos en el method scope por el type de id
		Node importantNode = this;
		if(importantNode.getScope().getParent() instanceof MethodScope)
		{
			//Sacamos el scope
			MethodScope ms = (MethodScope)(importantNode.getScope().getParent());
			//Revisamos la superclass para ver si está el tipo del id actual
			Variable var = ms.getSclass().attrs.get(id);
			if(var != null)
			{
				//Si tiene devolvemos
				return var.type;
			}
		}
		//Sino buscamos en el scope mismo
		importantNode = this;
		if(importantNode.getScope() instanceof MethodScope)
		{
			MethodScope ms = (MethodScope)(importantNode.getScope());
			//Revisamos la superclass para ver si está el tipo del id actual
			Variable var = ms.getSclass().attrs.get(id);
			if(var != null)
			{
				//Si tiene devolvemos
				return var.type;
			}
		}
		
		return "MISSING :C";
	}
}
