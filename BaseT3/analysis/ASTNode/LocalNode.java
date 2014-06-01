package analysis.ASTNode;
import java.util.*;
import analysis.*;
public class LocalNode extends Node
{
    private String id;


    public LocalNode(String id)
    {
	this.id = id;
    }

    public String toString()
    {
	return "local "+id;
    }
}
