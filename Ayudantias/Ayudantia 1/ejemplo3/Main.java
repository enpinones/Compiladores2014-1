;import java.io.*;

public class Main 
{
    public static void main(String[] args)
    {
	File f;
	Reader r;
	Scanner lex;
	int value, lineno;
	Symbol sym;

	try{
	    f = new File(args[0]);
	    r = new FileReader(f);
	    lex = new Scanner(r);

	    while((value = lex.yylex()) != Parser.EOF) {
		sym = lex.getSymbol();

		switch (value) {
		case Parser.LPAREN:
		    System.out.printf("left paren at %d\n", sym.lineno);
		    break;
		case Parser.RPAREN:
		    System.out.printf("right paren at %d\n", sym.lineno);
		    break;
		case Parser.ID:
		    System.out.printf("id %s at %d\n", lex.getLVal(), sym.lineno);
		    break;
		}
	    }
	}catch(FileNotFoundException fnf){
	    System.err.print("file not found\n");
	}catch(IOException i){
	    System.err.print("io exception\n");
	}
    }
}
