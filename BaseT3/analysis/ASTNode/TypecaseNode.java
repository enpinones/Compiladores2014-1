package analysis.ASTNode;
import java.util.*;
import analysis.*;
public class TypecaseNode extends Node
{
    private String id;

    public TypecaseNode(String id)
    {
	this.id = id;
    }

    public String toString()
    {
	return "typecase "+id;
    }
}
