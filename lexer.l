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

 /* Definición de macros */

lowercase_letter        = [a-z]
uppercase_letter        = [A-Z]
decimal_digit           = [0-9]
number                  = [0-9]*
letter                  = {lowercase_letter}|{uppercase_letter}
identifier              = {letter}({decimal_digit}|{letter}|[_])*
iter_name               = {identifier}[!]
uppercase_identifier    = {uppercase_letter}({decimal_digit}|{uppercase_letter}|[_])*
bool_literal_expresion  = true | false
//special_symbol          = [(][)][{][}][,][.][;][:][+][-][*][/][%][<][<=][=][/=][>][>=][~][:=][::][#]
special_symbol          = [(]|[)]|[{]|[}]|[,]|[.]|[;]|[:]|[+]|[-]|[*]|[/]|[%]|[<]|[<=]|[=]|[/=]|[>]|[>=]|[~]|[:=]|[::]|[#]
keyword                 = [and][attr][break!][class][else][elsif][end][false][if][include][is][loop][new][or][once][private][quit][return][SAME][self][then][true][typecase][void][when][while!][yield]

%xstate STRING
%xstate CHAR

%%

/* Uppercase Identifier */
{uppercase_identifier} {
    yylval = yytext();
    this.type = Parser.uppercase_identifier;
    return this.type;
}

/* Identifier */

{identifier} {
    yylval = yytext();
    this.type = Parser.identifier;
    return this.type;
}

/* Iterator name */

{iter_name} {
    yylval = yytext();
    this.type = Parser.iter_name;
    return this.type
}

/* Keywords */

{keyword} {
    yylval = yytext();
    this.type = Parser.keyword;
    return this.type
}

/* Symbols */

{special_symbol} {
    yylval = yytext();
    this.type = Parser.symbol;
    return this.type
}

/* Boolean */

{bool_literal_expresion} {
    yylval = yytext();
    this.type = Parser.bool;
    return this.type
}

/* Integer */

{number} {
    yylval = Integer.parseInt(yytext());
    this.type = Parser.integer;
    return this.type
}

/* Char */

{letter} {
    string.setLength(0);
    yybegin(CHAR);
}



/* String */

"\"" {
    string.setLength(0);
    yybegin(STRING);
}

<CHAR> {
    //Final del char
    "\'"
    {
        yylval = string.toString();
        yybegin(YYINITIAL);
        this.type = char;
        return this.type;
    }

    \\a   { string.append("\a");}
    \\b   { string.append("\b");}
    \\f   { string.append("\f");}
    \\n   { string.append("\n");}
    \\r   { string.append("\r");}
    \\t   { string.append("\t");}
    \\v   { string.append("\v");}
}


 <STRING> {
    //Final del string
     "\""     
     {
        yylval = string.toString();
        yybegin(YYINITIAL);
        this.type = string[string.length()];
        return Parser.STRING;
     }
    
    /* caracteres de escape */

    \\a   { string.append("\a");}
    \\b   { string.append("\b");}
    \\f   { string.append("\f");}
    \\n   { string.append("\n");}
    \\r   { string.append("\r");}
    \\t   { string.append("\t");}
    \\v   { string.append("\v");}

    /* Otros caracteres */
    \\\\  { string.append("\\");}

    /* resto */

    {letter} { string.append(yytext());}

    /* error */
    \\0 { System.out.printf("Invalid character [%s]\n", yytext());
          return Parser.T_NULL_CHARACTER;
        }
}
