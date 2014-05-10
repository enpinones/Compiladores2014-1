 /* -*- mode: java -*- */

%output "Parser.java"
%language "Java"
%locations

%define parser_class_name "Parser"
%define public

%code imports {
    import java.util.*;
    import java.io.*;
}

%code {
    private Node formula;

    /* 
     * se usa la "tabla de símbolos" de esta forma
     * solamente por que el lenguaje es muy simple.
     * En casos más complejos (como el proyecto), se
     * debería definir y procesar de forma externa.
     */
    private HashMap<String, Boolean> valuation = new HashMap<String, Boolean>();

    public Tree getAST() {
	 return new Tree(this.formula);
    }
}

%token OTHER
 /* 
  * Tokens
  */
%token LPAREN "("
%token RPAREN ")"
%token IMPLIES
%token EQUIVALENT
%token NOT
%token SIGMA
%token AND
%token OR
%token<Boolean> VALUE
%token EQUAL "="
%token <String> ID

 /*
  * Precedencias
  */
%left EQUIVALENT
%left IMPLIES
%left AND OR
%nonassoc NOT


 /*
  * tipos de variables
  */
%type <Node> variable formula program

%%
 /* nodo raiz. Es útil para manejar el árbol completo */
root : program {
    this.formula = $1;
};

 /* reglas de la gramática */
program : assign program {
    $$ = $2;
}
|
formula {
    $$ = $1;
};

assign: SIGMA "(" ID ")" "=" VALUE {
    String var_id = $3;
    Boolean value = $6;
    this.valuation.put(var_id, value);
};

variable : ID {
    Node ln = new Node();
    ln.setLabel($1);
    if( ! this.valuation.containsKey($1)) {
	yyerror(@1, "variable '"+$1+"' not defined");
	/* YYABORT detiene el proceso */
	return YYABORT;
    }
    ln.setValue(this.valuation.get($1));
    $$ = ln;
};

formula : variable {
    $$ = $1;
}
|
formula AND formula {
    Node fn = new Node();
    fn.setLabel("AND");
    fn.addChild($1);
    fn.addChild($3);
    /* 
     * En casos mas complejos, el valor debería
     * calcularse de forma externa, no en el parser.
     */
    fn.setValue($1.getValue() && $3.getValue());
    $$ = fn;
}
|
formula OR formula {
    Node fn = new Node();
    fn.setLabel("OR");
    fn.addChild($1);
    fn.addChild($3);
    fn.setValue($1.getValue() || $3.getValue());
    $$ = fn;
}
|
formula IMPLIES formula {
    Node fn = new Node();
    fn.setLabel("IMPLIES");
    fn.addChild($1);
    fn.addChild($3);
    fn.setValue(! $1.getValue() || $3.getValue());
    $$ = fn;
}
|
formula EQUIVALENT formula {
    Node fn = new Node();
    boolean left = $1.getValue();
    boolean right = $3.getValue();
    fn.setLabel("EQUIV");

    fn.addChild($1);
    fn.addChild($3);
    fn.setValue((left && right) || (!left && !right));
    $$ = fn;
}
|
NOT formula {
    Node nn = new Node();
    nn.setLabel("NOT");
    nn.setValue(! $2.getValue());
    nn.addChild($2);
    $$ = nn;
}
|
LPAREN formula RPAREN {
    $$ = $2;
};

%%

