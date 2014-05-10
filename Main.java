;import java.io.*;


public class Main
{
    public static void main(String[] args)
    {
	try {
	    File f = new File(args[0]);
	    Reader r = new FileReader(f);
	    Scanner s = new Scanner(r);
	    int value;

	    while((value = s.yylex()) != Parser.EOF) {
		if (value == Parser.CHAR) {
		    System.out.printf("%d(%d,%d):char:%s\n", s.getChar(), s.getLine(), s.beginCol, s.getPrintableString());
		}
		else if (value == Parser.STRING) {
		    System.out.printf("%d(%d,%d):string[%d]:%s\n", s.beginChar, s.beginLine, s.beginCol, s.getStrlen(), s.getPrintableString());
		}
		else if (value == Parser.BOOL) {
		    System.out.printf("%d(%d,%d):bool:%s\n", s.getChar(), s.getLine(), s.getColumn(), s.getLVal());
		}
		else if (value == Parser.INT) {
		    System.out.printf("%d(%d,%d):integer:%s\n", s.getChar(), s.getLine(), s.getColumn(), s.getLVal());
		}
		else if (value == Parser.UPCASE_ID) {
		    System.out.printf("%d(%d,%d):uppercase_identifier:%s\n", s.getChar(), s.getLine(), s.getColumn(), s.getLVal());
		}
		else if (value == Parser.ID) {
		    System.out.printf("%d(%d,%d):identifier:%s\n", s.getChar(), s.getLine(), s.getColumn(), s.getLVal());
		}
		else if (value == Parser.ITER_NAME) {
		    System.out.printf("%d(%d,%d):iter_name:%s\n", s.getChar(), s.getLine(), s.getColumn(), s.getLVal());
		}
		else if (value == Parser.ERROR) {
		    System.out.printf("LEXICAL_ERROR(%d,%d)\n", s.getLine(), s.getColumn());
		    break;
		}
		else if(s.isSymbol()) {
		    System.out.printf("%d(%d,%d):symbol:%s\n", s.getChar(), s.getLine(), s.getColumn(), s.getPrintableString());
		}
		else if (s.isKeyword()) {
		    System.out.printf("%d(%d,%d):keyword:%s\n", s.getChar(), s.getLine(), s.getColumn(), s.getPrintableString());
		}
	    }
	}catch(FileNotFoundException fnf){
	    System.err.println("file " + args[0] + " not found");
	}catch(IOException i){
	    System.err.println("io exception");
	}
    }
}
