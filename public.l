// -*- mode: java -*-
%%

%class Scanner
%unicode
%line
%char
%column
%public

%implements Parser.Lexer
%int

%{
    public static final int KEYWORD = 1;
    public static final int SYMBOL = 2;

    private Object yylval;
    private int type;
    /* posiciones para strings y chars */
    public int beginChar, beginLine, beginCol;

    private StringBuffer realString;
    private StringBuffer printableString;
    private int stCond;

    public Object getLVal()
    {
	return yylval;
    }

    public int getChar()
    {
	return yychar;
    }

    public int getLine()
    {
	return yyline;
    }

    public int getColumn()
    {
	return yycolumn;
    }

    public Boolean isKeyword()
    {
	return this.type == KEYWORD;
    }
    
    public Boolean isSymbol()
    {
	return this.type == SYMBOL;
    }

    public String getPrintableString()
    {
	return this.printableString.toString();
    }

    private void appendChar(char ch)
    {
	if (this.stCond == CHAR) {
	    this.yylval = ch;
	    yybegin(CHAR_END);
	}
	else {
	    this.realString.append(ch);
	    yybegin(STRING);
	}
    }

    public int getStrlen () 
    {
	return this.realString.length();
    }

    public void yyerror(String msg)
    {
	System.err.println(msg);
    }

    private void setSymbol(String str) 
    {
	this.type = SYMBOL;
	this.printableString.setLength(0);
	this.printableString.append(str);
    }

    private void setKeyword(String str) 
    {
	this.type = KEYWORD;
	this.printableString.setLength(0);
	this.printableString.append(str);
    }
%}

%init{
    this.type = 0;
    this.stCond = 0;
    this.realString = new StringBuffer();
    this.printableString = new StringBuffer();
%init}

ID = [a-zA-Z][a-zA-Z_0-9]*
WHITESPACE=[ \n\r\t]+

%x STRING
%x CHAR
%x ESCAPED
%x CHAR_END

%%

"and" { setKeyword("and"); return Parser.AND; }
"attr" { setKeyword("attr"); return Parser.ATTR; }
"break!" { setKeyword("break!"); return Parser.BREAK; }
"class" { setKeyword("class" );return Parser.CLASS; }
"else" { setKeyword("else" );return Parser.ELSE; }
"elsif" { setKeyword("elsif" );return Parser.ELSIF; }
"end" { setKeyword("end" );return Parser.END; }
"if" { setKeyword("if" );return Parser.IF; }
"include" { setKeyword("include" );return Parser.INCLUDE; }
"is" { setKeyword("is" );return Parser.IS; }
"loop" { setKeyword("loop" );return Parser.LOOP; }
"new" { setKeyword("new" );return Parser.NEW; }
"or" { setKeyword("or" );return Parser.OR; }
"once" { setKeyword("once" );return Parser.ONCE; }
"private" { setKeyword("private" );return Parser.PRIVATE; }
"quit" { setKeyword("quit" );return Parser.QUIT; }
"return" { setKeyword("return" );return Parser.RETURN; }
"SAME" { setKeyword("SAME" );return Parser.SAME; }
"self" { setKeyword("self" );return Parser.SELF; }
"then" { setKeyword("then" );return Parser.THEN; }
"typecase" { setKeyword("typecase" );return Parser.TYPECASE; }
"void" { setKeyword("void" );return Parser.VOID; }
"when" { setKeyword("when" );return Parser.WHEN; }
"yield" { setKeyword("yield" );return Parser.YIELD; }

"(" { setSymbol( "(" );return Parser.LPAREN; }
")" { setSymbol( ")" );return Parser.RPAREN; }
"{" { setSymbol( "{" );return Parser.LBRACE; }
"}" { setSymbol( "}" );return Parser.RBRACE; }
"," { setSymbol( "," );return Parser.COMMA; }
"." { setSymbol( "." );return Parser.DOT; }
";" { setSymbol( ";" );return Parser.SEMICOLON; }
"+" { setSymbol( "+" );return Parser.PLUS; }
"-" { setSymbol( "-" );return Parser.MINUS; }
"*" { setSymbol( "*" );return Parser.ASTERISK; }
"/" { setSymbol( "/" );return Parser.SLASH; }
"%" { setSymbol( "%" );return Parser.PERCENT; }
"<" { setSymbol( "<" );return Parser.LESS; }
">" { setSymbol( ">" );return Parser.GREATER; }
"<=" { setSymbol( "<=" );return Parser.LESSEQ; }
">=" { setSymbol( ">=" );return Parser.GREATEREQ; }
"/=" { setSymbol( "/=" );return Parser.DISTINCT; }
":=" { setSymbol( ":=" );return Parser.ASSIGN; }
":" { setSymbol( ":" );return Parser.COLON; }
"::" / [^=] { setSymbol( "::" );return Parser.DBLCOLON; }
"=" { setSymbol( "=" );return Parser.EQUAL; }
"~" { setSymbol( "~" );return Parser.TILDE; }
"#" { setSymbol( "#" );return Parser.SHARP; }

"true" {
    yylval = true;
    return Parser.BOOL; 
}

"false" {
    yylval = false;
    return Parser.BOOL;
}

-?[0-9]+ {
    yylval = Integer.parseInt(yytext()); 
    return Parser.INT; 
}

[A-Z][A-Z_]* {
    yylval = yytext(); 
    return Parser.UPCASE_ID; 
}

{ID}\! { 
    yylval = yytext(); 
    return Parser.ITER_NAME; 
}

{ID} { 
    yylval = yytext(); 
    return Parser.ID; 
}

<YYINITIAL> \' {
    this.stCond = CHAR;
    this.beginCol = yycolumn;
    this.beginChar = yychar;
    this.printableString.setLength(0);
    yybegin(CHAR);
}

<YYINITIAL> \" {
    this.stCond = STRING;
    this.beginChar = yychar;
    this.beginLine = yyline;
    this.beginCol = yycolumn;

    this.printableString.setLength(0);
    this.realString.setLength(0);
    yybegin(STRING);
}

<CHAR, STRING> \\ {
    yybegin(ESCAPED);
}

<ESCAPED> {

a {
    this.printableString.append("*alert*");
    appendChar('\007');
}

b {
    this.printableString.append("*backspace*");
    appendChar('\b');
}

f {
    this.printableString.append("*formfeed*");
    appendChar('\f');
}

n {
    this.printableString.append("*newline*");
    appendChar('\n');
}

r {
    this.printableString.append("*carret*");
    appendChar('\r');
}

t {
    this.printableString.append("*hortab*");
    appendChar('\t');
}

v {
    this.printableString.append("*verttab*");
    appendChar('\013');
}

\'|\" {
    char first = yycharat(0);
    this.printableString.append(first);
    appendChar(first);
}

[0-7]+ {
    char ch = (char) Integer.parseInt(yytext(), 8);
    this.printableString.append(ch);
    appendChar(ch);
}
}

<CHAR_END> \' {
    yybegin(YYINITIAL);
    return Parser.CHAR;
}

<CHAR> [^\\\'] {
    this.yylval = yycharat(0);
    this.printableString.append(this.yylval);
    yybegin(CHAR_END);
}

<STRING> [^\\\"]+ {
    this.printableString.append(yytext());
    this.realString.append(yytext());
}

<STRING> \"{WHITESPACE}?\" {

}

<STRING> \" {
    yylval = this.realString.toString();
    yybegin(YYINITIAL);
    return Parser.STRING;
}

{WHITESPACE} {

}

--.*$ {

}

 /* <*> [^] { */
<YYINITIAL,CHAR,STRING,CHAR_END,ESCAPED> [^] {
    yybegin(YYINITIAL);
    return Parser.ERROR;
}

<<EOF>> {
    return Parser.EOF; 
}
