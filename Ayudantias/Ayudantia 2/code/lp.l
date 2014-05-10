// -*- mode: java -*-

%%

%class Scanner
%unicode
%line
%public

%implements Parser.Lexer
%int

%{
    private Object yylval;
    private int type;

    public Object getLVal()
    {
	return yylval;
    }

    public void yyerror(Parser.Location loc, String msg)
    {
	System.out.printf("Error: %s\n", msg);
    }

    public Position getEndPos()
    {
	return null;
    }

    public Position getStartPos()
    {
	return null;
    }
%}

 /* macros */
ID = [a-zA-Z]+
WHITESPACE = [ \n	]+

%%

{ID} {
    yylval = yytext();
    return Parser.ID;
}

"→" {
    return Parser.IMPLIES;
}

"↔" {
    return Parser.EQUIVALENT;
}

"¬" {
    return Parser.NOT;
}

"σ" {
    return Parser.SIGMA;
}

"∧" {
    return Parser.AND;
}

"∨" {
    return Parser.OR;
}

"⊤" {
    yylval = true;
    return Parser.VALUE;
}

"⊥" {
    yylval = false;
    return Parser.VALUE;
}

"(" {
    return Parser.LPAREN;
}

")" {
    return Parser.RPAREN;
}

"=" {
    return Parser.EQUAL;
}

{WHITESPACE} {
    /* void */
}

[^] {
    return Parser.OTHER;
}

<<EOF>> {
    return Parser.EOF; 
}
