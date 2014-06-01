import java.io.*;
import analysis.ASTree;

public class Main
{
    public static void main(String[] args)
    {
	Executor ex = new Executor();
	if(args[0].equals("S")) {
	    ex.scan(args[1]);
	}
	else if (args[0].equals("T")){
	    ASTree ast = ex.parse(args[1]);
	    ast.print();
	}
    }
}
