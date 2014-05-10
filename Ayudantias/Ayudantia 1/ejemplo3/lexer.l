// -*- mode: java -*-

/* esto se agrega antes de la declaracion de la clase */

%%

%class Scanner
%unicode
%line
%public

%implements Parser.Lexer
%int

%{
    /* esto se copia dentro de la clase */
    private Object yylval;
    private int type;

    public Object getLVal()
    {
	return yylval;
    }

    public Symbol getSymbol()
    {
	return new Symbol(type, yyline);
    }

    public void yyerror(String msg){

    }
%}

%init{
    /* esto se copia dentro del constructor */
    this.type = 0;
%init}
 /* macros */
ID = [a-zA-Z_]+

%%

{ID} {
    yylval = yytext();
    this.type = Parser.ID;
    return this.type;
}

"(" {
    this.type = Parser.LPAREN;
    return this.type;
}

")" {
    this.type = Parser.RPAREN;
    return this.type;
}

[^] {
    this.type = Parser.OTHER;
    return this.type;
}

<<EOF>> {
    return Parser.EOF; 
}
