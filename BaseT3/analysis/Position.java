package analysis;

public class Position
{
    private int line;
    private int column;
    
    public Position(int line, int col)
    {
	this.line = line;
	this.column = col;
    }
    public Position(int line)
    {
	this.line = line;
	this.column = -1;
    }

    public boolean equals(Object ob)
    {
	Position p = (Position) ob;
	return p.line == this.line && p.column == this.column;
    }
    public String toString()
    {
	if(column != -1) {
	    return line+":"+column;
	}
	return line + "";
    }
}
