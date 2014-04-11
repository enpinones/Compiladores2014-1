%output  "Parser.java"
%language "Java"

%define parser_class_name "Parser"
%define public

%token OTHER
 /* opcionalmente se puede agregar un alias
  * al token, por ejemplo:
  */
%token LPAREN "("
%token RPAREN ")"
 /* lo anterior permite usar reemplazar LPAREN
  * por "(" en la gramatica
  */

 /* Si un token tiene un valor asociado (yylval),
  * se debe declarar el tipo de la siguiente forma
  */
%token <String> ID


%%
 /* reglas de la gramática */
a : LPAREN ID RPAREN {
     return 0;
}

%%
