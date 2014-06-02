// -*- mode: java -*-
%output  "Parser.java"
%language "Java"
%error-verbose
%locations
%define package analysis

%code {
     private ASTree ast;
     public ASTree getAST()
     {
	  return ast;
     }
}
%code imports {
    import java.util.*;
    import analysis.ASTNode.*;
    import analysis.*;
 }

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
%token TYPECASE
%token VOID
%token WHEN
%token WHILE
%token YIELD

%token LPAREN "("
%token RPAREN ")"
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
%token SHARP "#"

%left AND OR
%left "<" "<=" "=" "/=" ">=" ">"
%left "+" "-"
%left "*" "/" "%"
%left "~" UMINUS
%left "."

%nonassoc ";"

%type<Node> class_list class  class_def class_element include_clause class_element_list iter_argument iter_arg_list feature_modifier feature_modifier_list statement assign_statement if_statement return_statement typecase_statement expression expression_statement loop_statement yield_statement elseif_expre elseif_list when_expr when_list expression_list  sugar_expression statement_list create_expression call_expression
%type<AttrNode> public_attr_definition attr_definition
%type<MethodNode> routine_def_public routine_definition
%type<ArgNode> routine_argument routine_arg_list
%type<IterNode> iter_definition iter_definition_public
%type<String> type_specifier call_name name
%type<StringList> identifier_list type_spec_list subtyping_clause

%%
source : class_list {
    SimpleNode program = new SimpleNode("program");
    program.addChild($1);
    this.ast = new ASTree(program);
    return YYACCEPT;
 };

semicolon_list : ";" {
    /* void */
 }
|
 semicolon_list ";"{
    /* void */
};

class_list : class_list ";" class {
    $1.addToList($3);
    $$ = $1;
 }
|
class {
    $$ = $1;
}
;

type_specifier : UPCASE_ID {
    $$ = $1;
}
|
SAME {
    $$ = "SAME";
};

name : UPCASE_ID {
    $$ = $1;
}
|
ID {
    $$ = $1;
};

routine_argument : ID ":" type_specifier {
    ArgNode first = new ArgNode($1, $3);
    $$ = first;
}
|
identifier_list "," ID ":" type_specifier {
    ArgNode first = new ArgNode($1.car, $5);

    ArgNode aux;
    StringList iter = $1.cdr;
    ArgNode nw = new ArgNode($3,$5);
    int i;

    while (iter != null) {
	aux = new ArgNode(iter.car, $5);
	first.addToList(aux);
	iter=iter.cdr;
    }
    first.addToList(nw);
    $$ = first;
}

identifier_list : name {
    StringList l = new StringList();

    l.car = $1;
    l.cdr = null;
    $$ = l;
}
|
identifier_list "," name {
    $1.append($3);
    $$ = $1;
};

subtyping_clause : "<" type_spec_list {
    $$ = $2;
};

type_spec_list : type_spec_list "," type_specifier {
    //    $3.add(0, $1);
    StringList sl = new StringList();
    sl.car = $3;
    sl.cdr = $1;
    $$ = sl;
}
|
type_specifier {
    StringList sl = new StringList();
    sl.car = $1;
    sl.cdr = null;
    $$ = sl;
};

class_def : UPCASE_ID {
    ClassNode cl = new ClassNode($1);
    $$ = cl;
}
| 
UPCASE_ID subtyping_clause {
    ClassNode cl = new ClassNode($1);
    cl.setSuperTypes($2.toList());
    $$ = cl;
}
;

class : CLASS class_def IS class_element_list END {
    $2.addChild($4);
    $$ = $2;
};

class_element : attr_definition {
    $$ = $1;
}
|
routine_definition {
    $$ = $1;
}
|
iter_definition {
    $$ = $1;
}
|
include_clause {
    $$ = $1;
};

class_element_list : class_element {
    $$ = $1;
}
|
class_element_list ";" class_element {
    $1.addToList($3);
}
|
class_element_list ";" {
    $$ = $1;
}
|
";" {
    /* void */
}
;

attr_definition: public_attr_definition {
    $$ = $1;
}
|
PRIVATE public_attr_definition {
    $2.setPrivate();
    $$ = $2;
};

public_attr_definition : ATTR identifier_list ":" type_specifier {
    AttrNode first = new AttrNode($2.car, $4);
    AttrNode aux;
    StringList iter = $2.cdr;

    while(iter != null) {
	aux = new AttrNode(iter.car, $4);
	first.addToList(aux);
	iter = iter.cdr;
    }

    $$ = first;
};

routine_arg_list : routine_argument {
    $$ = $1;
}
|
routine_arg_list "," routine_argument {
    $1.addToList($3);
    $$ = $1;
};

routine_def_public : ID IS statement_list END{
    MethodNode aux = new MethodNode($1, null);
    SimpleNode body = new SimpleNode("body");
    aux.addChild(body);
    body.addChild($3);
    $$ = aux;
}
|
ID "(" routine_arg_list ")" IS statement_list END {
    MethodNode aux = new MethodNode($1, null);
    SimpleNode body = new SimpleNode("body");
    SimpleNode args = new SimpleNode("arguments");
    args.addChild($3);
    body.addChild($6);
    aux.addChild(args);
    aux.addChild(body);
    $$ = aux;
}
|
ID ":" type_specifier IS statement_list END {
    MethodNode aux = new MethodNode($1, $3);
    SimpleNode body = new SimpleNode("body");
    aux.addChild(body);
    body.addChild($5);
    $$ = aux;
}
|
ID "(" routine_arg_list ")" ":" type_specifier IS statement_list END {
    MethodNode aux = new MethodNode($1, $6);
    SimpleNode body = new SimpleNode("body");
    SimpleNode args = new SimpleNode("arguments");
    args.addChild($3);
    body.addChild($8);
    aux.addChild(args);
    aux.addChild(body);
    $$ = aux;
};
routine_definition : routine_def_public {
    $$ = $1;
}
|
PRIVATE routine_def_public {
    MethodNode aux = $2;
    aux.setPrivate();
    $$ = aux;
};

iter_argument : routine_argument {
    $$ = $1;
}
|
ONCE routine_argument {
    $2.setOnce();
    $$ = $2;
};
iter_arg_list : iter_argument {
    $$ = $1;
}
|
iter_argument "," iter_arg_list {
    $1.setRightBrother($3);
    $$ = $1;
};

iter_definition_public : ITER_NAME IS statement_list END {
    IterNode in = new IterNode($1);
    SimpleNode body = new SimpleNode("body");
    body.addChild($3);
    in.addChild(body);
    $$ = in;
}
|
ITER_NAME "(" iter_arg_list ")" IS statement_list END {
    IterNode in = new IterNode($1);
    SimpleNode args = new SimpleNode("arguments");
    args.addChild($3);
    SimpleNode body = new SimpleNode("body");
    body.addChild($6);
    in.addChild(args);
    in.addChild(body);
    $$ = in;
}
|
ITER_NAME ":" type_specifier IS statement_list END {
    IterNode in = new IterNode($1, $3);
    SimpleNode body = new SimpleNode("body");
    body.addChild($5);
    in.addChild(body);
    $$ = in;
}
|
ITER_NAME "(" iter_arg_list ")"  ":" type_specifier IS statement_list END {
    IterNode in = new IterNode($1, $6);
    SimpleNode args = new SimpleNode("arguments");
    args.addChild($3);
    SimpleNode body = new SimpleNode("body");
    body.addChild($8);
    in.addChild(args);
    in.addChild(body);
    $$ = in;
};

iter_definition : iter_definition_public {
    $$ = $1;
}
|
PRIVATE iter_definition_public {
    $2.setPrivate();
    $$ = $2;
}
feature_modifier : ID "-" ID {
    TransfNode tn = new TransfNode($1, $3);
    $$ = tn;
}
|
ITER_NAME "-" ITER_NAME {
    TransfNode tn = new TransfNode($1, $3);
    $$ = tn;
};

feature_modifier_list : feature_modifier {
    $$ = $1;
}
|
feature_modifier "," feature_modifier_list {
    $1.setRightBrother($3);
    $$ = $1;
};

include_clause : INCLUDE type_specifier feature_modifier_list{
    IncludeNode in = new IncludeNode($2);
    in.addChild($3);
    $$ = in;
}
|
INCLUDE type_specifier{
    IncludeNode in = new IncludeNode($2);
    $$ = in;
}
;

statement_list : statement {
    $$ = $1;
}
|
";" statement_list {
    $$ = $2;
}
|
statement semicolon_list {
    $$ = $1;
}
|
statement ";" statement_list {
    $1.addToList($3);
    $$ = $1;
};


statement : routine_argument {
    $$ = $1;
}
|
assign_statement {
    $$ = $1;
}
|
if_statement {
    $$ = $1;
}
|
return_statement {
    $$ = $1;
}
|
typecase_statement {
    $$ = $1;
}
|
expression_statement {
    $$ = $1;
}
|
loop_statement {
    $$ = $1;
}
|
yield_statement {
    $$ = $1;
}
|
QUIT {
    SimpleNode sn = new SimpleNode("quit");
    $$ = sn;
};

assign_statement : expression ":=" expression {
    AssignNode as = new AssignNode();
    as.addChild($1);
    as.addChild($3);
    $$ = as;
}
|
ID ":" ":=" expression {
    AssignNode as = new AssignNode($1);
    as.addChild($4);
    $$ = as;
}
|
ID ":" type_specifier ":=" expression {
    AssignNode as = new AssignNode($1, $3);
    as.addChild($5);
    $$ = as;
};

elseif_expre : ELSIF expression THEN statement_list {
    SimpleNode cond = new SimpleNode("condition");
    cond.addChild($2);
    SimpleNode body = new SimpleNode("body");
    body.addChild($4);
    cond.addChild(body);

    $$ = cond;
};

elseif_list : elseif_expre {
    $$ = $1;
}
|
elseif_expre elseif_list {
    $1.setRightBrother($2);
    $$ = $1;
};


if_statement : IF expression THEN statement_list END {
    SimpleNode sn = new SimpleNode("if");
    SimpleNode cond = new SimpleNode("condition");
    cond.addChild($2);
    SimpleNode body = new SimpleNode("body");
    cond.addChild(body);
    body.addChild($4);
    sn.addChild(cond);
    $$ = sn;
}
|
IF expression THEN statement_list elseif_list END {
    SimpleNode sn = new SimpleNode("if");
    SimpleNode cond = new SimpleNode("condition");
    cond.addChild($2);
    SimpleNode body = new SimpleNode("body");
    cond.addChild(body);
    body.addChild($4);

    cond.setRightBrother($5);

    sn.addChild(cond);
    $$ = sn;
}
|
IF expression THEN statement_list ELSE statement_list END {
    SimpleNode sn = new SimpleNode("if");
    SimpleNode cond = new SimpleNode("condition");
    cond.addChild($2);
    SimpleNode body = new SimpleNode("body");
    cond.addChild(body);
    body.addChild($4);
    SimpleNode els = new SimpleNode("else");
    els.addChild($6);
    cond.addToList(els);
    sn.addChild(cond);
    $$ = sn;
}
|
IF expression THEN statement_list elseif_list ELSE statement_list END {
    SimpleNode sn = new SimpleNode("if");
    SimpleNode cond = new SimpleNode("condition");
    cond.addChild($2);
    SimpleNode body = new SimpleNode("body");
    cond.addChild(body);
    body.addChild($4);
    cond.setRightBrother($5);
    SimpleNode els = new SimpleNode("else");
    els.addChild($7);
    cond.addToList(els);
    sn.addChild(cond);
    $$ = sn;
};

return_statement : RETURN {
    SimpleNode sn = new SimpleNode("return");
    $$ = sn;
}
|
RETURN expression {
    SimpleNode sn = new SimpleNode("return");
    sn.addChild($2);
    $$ = sn;
};

when_expr : WHEN type_specifier THEN statement_list {
    SimpleNode sn = new SimpleNode($2);
    sn.addChild($4);
    $$ = sn;
};

when_list : when_expr {
    $$ = $1;
}
|
when_list when_expr {
    $1.addToList($2);
    $$ = $1;
};

typecase_statement : TYPECASE ID when_list END {
    TypecaseNode sn = new TypecaseNode($2);
    sn.addChild($3);
    $$ = sn;    
}
|
TYPECASE ID when_list ELSE statement_list END {
    TypecaseNode sn = new TypecaseNode($2);
    SimpleNode els = new SimpleNode("else");
    els.addChild($5);
    $3.addToList(els);
    sn.addChild($3);
    $$ = sn;
};

expression_statement : expression {
    $$ = $1;
};

expression : BOOL {
    LiteralNode ln = new LiteralNode("BOOL", $1.toString());
    $$ = ln;
}
|
CHAR {
    LiteralNode ln = new LiteralNode("CHAR", "\'"+$1+"\'");
    $$ = ln;
}
|
STRING {
    LiteralNode ln = new LiteralNode("STR", "\""+$1+"\"");
    $$ = ln;
}
|
INT {
    LiteralNode ln = new LiteralNode("INT", $1+"");
    $$ = ln;
}
|
SELF {
    SimpleNode sn = new SimpleNode("self");
    $$ = sn;
}
|
ID {
    LocalNode ln = new LocalNode($1);
    $$ = ln;
}
|
call_expression {
    $$= $1;
}
|
VOID {
    SimpleNode sn = new SimpleNode("void");
    $$ = sn;
}
|
VOID "(" expression ")" {
    SimpleNode sn = new SimpleNode("void");
    sn.addChild($3);
    $$ = sn;
}
|
NEW {
    SimpleNode sn = new SimpleNode("new");
    $$ = sn;
}
|
create_expression {
    $$ = $1;
}
|
sugar_expression {
    $$ = $1;
}
|
WHILE "(" expression ")" {
    SimpleNode sn = new SimpleNode("while");
    sn.addChild($3);
    $$ = sn;
}
|
BREAK {
    SimpleNode sn = new SimpleNode("break");
    $$ = sn;
};

call_name : ID {
    $$ = $1;
}
|
ITER_NAME {
    $$ = $1;
};

expression_list : expression {
    $$ = $1;
}
|
expression "," expression_list {
    $1.setRightBrother($3);
    $$ = $1;
};

call_expression : expression "." call_name {
    CallNode cd = new CallNode($3);
    SimpleNode caller = new SimpleNode("caller");
    caller.addChild($1);
    cd.addChild(caller);
    $$ = cd;
}
|
expression "." call_name "(" expression_list ")" {
    CallNode cd = new CallNode($3);
    SimpleNode caller = new SimpleNode("caller");
    SimpleNode args = new SimpleNode("arguments");
    caller.addChild($1);
    args.addChild($5);
    cd.addChild(caller);
    cd.addChild(args);
    $$ = cd;

};

create_expression : "#" {
    CreateNode cn = new CreateNode("");
    $$ = cn;
}
|
"#" type_specifier {
    CreateNode cn = new CreateNode($2);
    $$ = cn;
}
|
"#" type_specifier "(" expression_list ")" {
    CreateNode cn = new CreateNode($2);
    cn.addChild($4);
    $$ = cn;
}
|
"#" "(" expression_list ")" {
    CreateNode cn = new CreateNode("");
    cn.addChild($3);
    $$ = cn;
};
 /*
  * (defun insert-binary (op) 
      (insert "expression \"" op "\" expression {
  BinaryNode bn = new BinaryNode ( \""  op "\" );
  bn.addChild($1);
  bn.addChild($3);
  $$ = bn;
}
|"))
  * 
  */
sugar_expression : expression AND expression {
    SimpleNode sn = new SimpleNode("and");
    sn.addChild($1);
    sn.addChild($3);
    $$ = sn;
}
|
expression OR expression {
    SimpleNode sn = new SimpleNode("or");
    sn.addChild($1);
    sn.addChild($3);
    $$ = sn;
}
|
 // (mapcar 'insert-binary '("+" "-" "*" "/" "%" "<" "<=" "=" "/=" ">" ">="))
expression "+" expression {
  BinaryNode bn = new BinaryNode ( "+" );
  bn.addChild($1);
  bn.addChild($3);
  $$ = bn;
}
|expression "-" expression {
  BinaryNode bn = new BinaryNode ( "-" );
  bn.addChild($1);
  bn.addChild($3);
  $$ = bn;
}
|expression "*" expression {
  BinaryNode bn = new BinaryNode ( "*" );
  bn.addChild($1);
  bn.addChild($3);
  $$ = bn;
}
|expression "/" expression {
  BinaryNode bn = new BinaryNode ( "/" );
  bn.addChild($1);
  bn.addChild($3);
  $$ = bn;
}
|expression "%" expression {
  BinaryNode bn = new BinaryNode ( "%" );
  bn.addChild($1);
  bn.addChild($3);
  $$ = bn;
}
|expression "<" expression {
  BinaryNode bn = new BinaryNode ( "<" );
  bn.addChild($1);
  bn.addChild($3);
  $$ = bn;
}
|expression "<=" expression {
  BinaryNode bn = new BinaryNode ( "<=" );
  bn.addChild($1);
  bn.addChild($3);
  $$ = bn;
}
|expression "=" expression {
  BinaryNode bn = new BinaryNode ( "=" );
  bn.addChild($1);
  bn.addChild($3);
  $$ = bn;
}
|expression "/=" expression {
  BinaryNode bn = new BinaryNode ( "/=" );
  bn.addChild($1);
  bn.addChild($3);
  $$ = bn;
}
|expression ">" expression {
  BinaryNode bn = new BinaryNode ( ">" );
  bn.addChild($1);
  bn.addChild($3);
  $$ = bn;
}
|expression ">=" expression {
  BinaryNode bn = new BinaryNode ( ">=" );
  bn.addChild($1);
  bn.addChild($3);
  $$ = bn;
}
|
"-" expression %prec UMINUS { 
    UnaryNode un = new UnaryNode("-");
    un.addChild($2);
    $$ = un;
}
|
"(" expression ")" {
    $$ = $2;
}
|
"~" expression {
    UnaryNode un = new UnaryNode("~");
    un.addChild($2);
    $$ = un;
};

loop_statement : LOOP statement_list END {
    SimpleNode sn = new SimpleNode("loop");
    sn.addChild($2);
    $$ = sn;
};

yield_statement : YIELD {
    SimpleNode sn = new SimpleNode("yield");
    $$ = sn;
}
|
YIELD expression {
    SimpleNode sn = new SimpleNode("yield");
    sn.addChild($2);
    $$ = sn;
};

%%

class StringList
{
    public String car;
    public StringList cdr;
    public StringList()
    {
	this.car = null;
	this.cdr = null;
    }
    public ArrayList<String> toList()
    {
	ArrayList<String> ret = new ArrayList<String>();
	StringList iter = this;
	while(iter != null) {
	    ret.add(iter.car);
	    iter=iter.cdr;
	}
	Collections.reverse(ret);
	return ret;
    }
    public void append(String val)
    {
	StringList l = new StringList();
	l.car = val;
	l.cdr = null;
	StringList iter = this;
	while(iter.cdr != null) {
	    iter = iter.cdr;
	}
	iter.cdr = l;
    }
}
