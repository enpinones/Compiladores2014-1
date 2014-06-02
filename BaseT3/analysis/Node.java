package analysis;

import java.util.ArrayList;
import java.util.List;

public abstract class Node {
    private Node leftChild;
    private Node rightBrother;
    private Node parent;
    private Node scope;
    private List <String> errors;
    
    public Node()
    {
	this.leftChild = null;
	this.rightBrother = null;
	this.parent = null;
	this.scope = null;
	this.errors = new ArrayList<String>();
    }

    public List<String> getErrors()
    {
    	return errors;
    }
    public void setRightBrother(Node r)
    {
	this.rightBrother = r;
    }
    public void addToList(Node n)
    {
	Node aux = this;
	while (aux.rightBrother != null) {
	    aux = aux.rightBrother;
	}
	aux.rightBrother = n;
    }
    public Node leftChild()
    {
	return this.leftChild;
    }
    public void setLeftChild(Node n)
    {
	this.leftChild = n;
	n.setParent(this);
    }
    public Node rightBrother()
    {
	return this.rightBrother;
    }
    public boolean rightBrotherp()
    {
	return this.rightBrother != null;
    }
    public void setScope(Node sc)
    {
	this.scope = sc;
    }
    public void setParent(Node par)
    {
	this.parent = par;
    }
    public Node getParent()
    {
	return this.parent;
    }
    public Node getScope()
    {
	return this.scope;
    }
    public int countSubtree()
    {
	int ret = 1;
	Node aux = leftChild;
	while(aux != null) {
	    ret += aux.countSubtree();
	    aux = aux.rightBrother;
	}
	return ret;
    }
    public void addChild (Node child)
    {
	Node next = leftChild;
	if (next == null) {
	    leftChild = child;
	    child.setParent(this);
	    return;
	}

	while (next.rightBrother != null) {
	    next = next.rightBrother;
	}
	next.rightBrother = child;
	child.setParent(this);
    }
}
