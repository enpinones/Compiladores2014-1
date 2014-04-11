// -*- mode: java -*-

import java.io.*;

%%

%unicode
%class Scanner
%int

%{
    private int commented_lines = 0;
    private int comment_nesting = 0;
    private int word_count = 0;

    public int print_data() {
	System.out.printf("%d %d\n", this.commented_lines, this.word_count);
	return 0;
    }

    public int yyerror(String arg){
	return 0;
    }
%}

white = [ \t\r]+
word = [^ \t\r*]+

%s COMMENT

%%

<YYINITIAL> "/*" {
    yybegin(COMMENT);
    comment_nesting ++;
}

<COMMENT> {

"*/" {
    comment_nesting --;
    if(comment_nesting == 0){
	yybegin(YYINITIAL);
    }
}

"/*" {
    comment_nesting ++;
}

\n {
    commented_lines ++;
}
}


 /* notar que al cambiar el tipo de
  * estado de COMMENT, el valor cambia,
  * ya que esta regla no esta activa cuando
  * COMMENT es exclusivo.
  */
[^ \n\r\t*]+ {
    word_count ++;
}

<YYINITIAL, COMMENT> [^] {
    /* void */
}

<<EOF>> {
    return print_data();
}
