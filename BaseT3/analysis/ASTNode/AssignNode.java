package analysis.ASTNode;
import java.util.*;
import analysis.*;
public class AssignNode extends Node
{
    private String type;
    private String id;

    public String getType()
    {
	return this.type;
    }
    public String getId()
    {
	return this.id;
    }
    public AssignNode(String id, String type)
    {
	this.type = type;
	this.id = id;
    }

    public AssignNode(String id)
    {
	this.type = null;
	this.id = id;
    }

    public AssignNode()
    {
	this.type = null;
	this.id = null;
    }

    public String toString()
    {
    	//Buscamos el tipo si no lo tiene
    	if(type == null)
    		SearchType();
		if(type != null && id != null) {
		    return "assign "+id + ":" + type;
		}
		if (id != null) {
		    return "assign "+id;
		}
		return "assign";
    }
    
    //Revisamos el tipo de la asignacion
    public void SearchType()
    {
    	//Buscamos hijos hasta encontrar un literal node
    	Node importantNode = FindLiteralNode(this);
    	if (importantNode != null)
    	{
    		LiteralNode litNode = (LiteralNode)importantNode;
    		this.type=litNode.GetType();
    	}
    }
    
    //Función recursiva para encontrar un hermano/hijo que sea LiteralNode
    public Node FindLiteralNode(Node node)
    {
    	Node foundNode = null;
    	if(node instanceof LiteralNode)
    		foundNode = node;
    	else
    	{
    		//Buscamos en hermanos
    		if(node.rightBrotherp())
    		{
    			foundNode = FindLiteralNode(node.rightBrother());
    		}
    		//Buscamos en hijos
    		if(node.leftChild()!=null)
    		{
    			foundNode = FindLiteralNode(node.leftChild());
    		}
    	}
    	return foundNode;
    	
    }
}
