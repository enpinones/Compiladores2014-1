import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
	try{
	    File f = new File(args[0]);
	    Reader r = new FileReader(f);
	
	    Scanner lex = new Scanner(r);
	    lex.yylex();
	}catch(FileNotFoundException fe) {
	    System.err.print("file not found\n");
	}catch(IOException i){
	    System.err.print("IOException\n");
	}
    }
}
