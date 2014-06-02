package analysis.ASTNode;
import java.util.*;
import analysis.*;
import analysis.symtable.MethodScope;
import analysis.symtable.VarScope;
import analysis.symtable.Variable;
public class LocalNode extends Node
{
	private String id;


	public LocalNode(String id)
	{
		this.id = id;
	}

	public String toString()
	{
		return "local "+id+" <"+GetType()+">";
	}

	private String GetType()
	{
		//Primero revisamos si esta definido en el scope de un metodo, para revisa sus variables
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
		if(importantNode.getScope() instanceof MethodScope)
		{
			//Sacamos el scope
			MethodScope ms = (MethodScope)(importantNode.getScope());
			//Revisamos la superclass para ver si está el tipo del id actual
			ArrayList args = ms.method.args;
			if(args != null)
			{
				for(int i=0;i<args.size();i++)
				{
					Variable var = (Variable)args.get(i);
					if(var.getName().equals(id))
					{
						return var.getType();
					}

				}
			}
		}
		//Sino reviamos los hermanos por Nodos literales
		importantNode = this;
		while(importantNode.rightBrotherp())
		{
			importantNode = this.rightBrother();
			if(importantNode instanceof LiteralNode)
			{
				LiteralNode litNode = (LiteralNode)importantNode;
				return litNode.GetType();
			}
			else if (importantNode instanceof LocalNode)
			{
				//Se llega aqui en caso de que el padre de una operación binaria, comprobamos de que tipo es
				if(importantNode.getParent() instanceof BinaryNode)
				{
					BinaryNode binNode = (BinaryNode)importantNode.getParent();
					return binNode.GetOperatorType();	
				}
			}
		}
		//Sino retornamos el tipo de scope que estamos
		importantNode = this;
		if(importantNode.getScope() instanceof VarScope)
		{
			VarScope vs = (VarScope)importantNode.getScope();
			//Si no es vacio
			Variable var = vs.getVar(id);
			if(var != null)
			{
				return var.getType();
			}
		}

		System.out.println(importantNode.getScope());
		return "MISSING :C";	
	}

	public Node FindAssignNodeWithType(Node node)
	{
		//Revisamos el nodo
		Node foundNode = null;
		if(node instanceof AssignNode)
		{
			AssignNode asgNode = (AssignNode)node;
			if(asgNode.getType() != null)
				foundNode = asgNode;
		}
		//Revisamos los hermanos
		else
		{
			//Buscamos en hermanos
			if(node.rightBrotherp())
			{
				foundNode = FindAssignNodeWithType(node.rightBrother());
			}
		}
		return foundNode;

	}
}
