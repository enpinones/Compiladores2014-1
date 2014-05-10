public class Node
{
    private boolean value;
    private String label;
    private Node leftChild;
    private Node rightBrother;

    public Node ()
    {
	leftChild = null;
	rightBrother = null;
    }

    public void setLabel(String str)
    {
	this.label = str;
    }

    public void setValue(boolean val)
    {
	this.value = val;
    }

    public boolean getValue()
    {
	return value;
    }
    
    public Node leftChild()
    {
	return leftChild;
    }
    public Node rightBrother()
    {
	return rightBrother;
    }
    public boolean rightBrotherp()
    {
	return rightBrother != null;
    }

    public void addChild (Node child)
    {
	Node next = leftChild;
	if (next == null) {
	    leftChild = child;
	    return;
	}

	while (next.rightBrother != null) {
	    next = next.rightBrother;
	}

	next.rightBrother = child;
    }
    
    public String toString()
    {
	return this.label + " <" + this.value + ">";
    }
}
