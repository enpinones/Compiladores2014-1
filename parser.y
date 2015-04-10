%output  "Parser.java"
%language "Java"


%define parser_class_name "Parser"
%define public

%token <String> ID
%token <String> STRING
%token <String> UPCASE_ID
%token <String> ITER_NAME
%token <Integer> INT
%token <Boolean> BOOL
%token <Character> CHAR

%token ERROR

%token AND
%token ATTR
%token BREAK
%token CLASS
%token ELSE
%token ELSIF
%token END
%token FALSE
%token IF
%token INCLUDE
%token IS
%token LOOP
%token NEW
%token OR
%token ONCE
%token PRIVATE
%token QUIT
%token RETURN
%token SAME
%token SELF
%token THEN
%token TRUE
%token TYPECASE
%token VOID
%token WHEN
%token WHILE
%token YIELD

%token LPAREN "("
%token RPAREN ")"
%token LBRACE "{"
%token RBRACE "}"
%token COMMA ","
%token DOT "."
%token SEMICOLON ";"
%token COLON ":"
%token PLUS "+"
%token MINUS "-"
%token ASTERISK "*"
%token SLASH "/"
%token PERCENT "%"
%token LESS "<"
%token LESSEQ "<="
%token EQUAL "="
%token DISTINCT "/="
%token GREATER ">"
%token GREATEREQ ">="
%token TILDE "~"
%token ASSIGN ":="
%token DBLCOLON "::"
%token SHARP "#"


%%
source : ;


%%
