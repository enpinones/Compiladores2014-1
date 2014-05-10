import java.io.*;

public class Main
{

    public static void main(String[] args)
    {
	File f;
	Reader r;
	Scanner lex;
	Parser par;
	int value, lineno;
	Tree ast;

	try{
	    f = new File(args[0]);
	    r = new FileReader(f);
	    lex = new Scanner(r);
	    par = new Parser(lex);
	    if(par.parse()) {
		ast = par.getAST();
		ast.print();
	    }
	}catch(FileNotFoundException fnf){
	    System.err.print("file not found\n");
	}catch(IOException i){
	    System.err.print("io exception\n");
	}
    }
}
