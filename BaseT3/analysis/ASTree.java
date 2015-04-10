package analysis;

import java.io.*;
import analysis.ASTNode.*;

public class ASTree
{
    private Node root;

    public ASTree(Node root)
    {
	this.root = root;
    }

    public Node getRoot()
    {
	return root;
    }

    public void print()
    {
	print(root, "", "");
    }

    private void print(Node nd, String prefix1, String prefix2)
    {
	System.out.printf("%s%s\n", prefix1, nd.toString());
	Node aux = nd.leftChild();

	if(aux == null) {
	    return;
	}

	while(aux.rightBrotherp()) {
	    print(aux, prefix2 + "|-- ", prefix2 + "|   ");
	    aux = aux.rightBrother();
	}
	print(aux, prefix2 + "|-- ", prefix2 + "    ");
    }
}
