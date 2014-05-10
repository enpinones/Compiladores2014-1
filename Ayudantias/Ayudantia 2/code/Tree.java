import java.io.*;

public class Tree
{
    private Node root;

    public Tree(Node root)
    {
	this.root = root;
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
	    print(aux, prefix2 + "├─ ", prefix2 + "│  ");
	    aux = aux.rightBrother();
	}
	print(aux, prefix2 + "└─ ", prefix2 + "    ");
    }

}
