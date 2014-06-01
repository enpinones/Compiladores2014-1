/* A Bison parser, made by GNU Bison 2.7.12-4996.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java
   
      Copyright (C) 2007-2013 Free Software Foundation, Inc.
   
   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.
   
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
   
   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.
   
   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

package analysis;
/* First part of user declarations.  */

/* "%code imports" blocks.  */
/* Line 32 of lalr1.java  */
/* Line 15 of "parser.y"  */

    import java.util.*;
    import analysis.ASTNode.*;
    import analysis.*;
 

/* Line 32 of lalr1.java  */
/* Line 47 of "Parser.java"  */

/**
 * A Bison parser, automatically generated from <tt>parser.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class Parser
{
    /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "2.7.12-4996";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";


  /** True if verbose error messages are enabled.  */
  public boolean errorVerbose = true;


  /**
   * A class defining a pair of positions.  Positions, defined by the
   * <code>Position</code> class, denote a point in the input.
   * Locations represent a part of the input through the beginning
   * and ending positions.  */
  public class Location {
    /** The first, inclusive, position in the range.  */
    public Position begin;

    /** The first position beyond the range.  */
    public Position end;

    /**
     * Create a <code>Location</code> denoting an empty range located at
     * a given point.
     * @param loc The position at which the range is anchored.  */
    public Location (Position loc) {
      this.begin = this.end = loc;
    }

    /**
     * Create a <code>Location</code> from the endpoints of the range.
     * @param begin The first position included in the range.
     * @param end   The first position beyond the range.  */
    public Location (Position begin, Position end) {
      this.begin = begin;
      this.end = end;
    }

    /**
     * Print a representation of the location.  For this to be correct,
     * <code>Position</code> should override the <code>equals</code>
     * method.  */
    public String toString () {
      if (begin.equals (end))
        return begin.toString ();
      else
        return begin.toString () + "-" + end.toString ();
    }
  }



  /** Token returned by the scanner to signal the end of its input.  */
  public static final int EOF = 0;

/* Tokens.  */
  /** Token number, to be returned by the scanner.  */
  public static final int ID = 258;
  /** Token number, to be returned by the scanner.  */
  public static final int STRING = 259;
  /** Token number, to be returned by the scanner.  */
  public static final int UPCASE_ID = 260;
  /** Token number, to be returned by the scanner.  */
  public static final int ITER_NAME = 261;
  /** Token number, to be returned by the scanner.  */
  public static final int INT = 262;
  /** Token number, to be returned by the scanner.  */
  public static final int BOOL = 263;
  /** Token number, to be returned by the scanner.  */
  public static final int CHAR = 264;
  /** Token number, to be returned by the scanner.  */
  public static final int ERROR = 265;
  /** Token number, to be returned by the scanner.  */
  public static final int AND = 266;
  /** Token number, to be returned by the scanner.  */
  public static final int ATTR = 267;
  /** Token number, to be returned by the scanner.  */
  public static final int BREAK = 268;
  /** Token number, to be returned by the scanner.  */
  public static final int CLASS = 269;
  /** Token number, to be returned by the scanner.  */
  public static final int ELSE = 270;
  /** Token number, to be returned by the scanner.  */
  public static final int ELSIF = 271;
  /** Token number, to be returned by the scanner.  */
  public static final int END = 272;
  /** Token number, to be returned by the scanner.  */
  public static final int IF = 273;
  /** Token number, to be returned by the scanner.  */
  public static final int INCLUDE = 274;
  /** Token number, to be returned by the scanner.  */
  public static final int IS = 275;
  /** Token number, to be returned by the scanner.  */
  public static final int LOOP = 276;
  /** Token number, to be returned by the scanner.  */
  public static final int NEW = 277;
  /** Token number, to be returned by the scanner.  */
  public static final int OR = 278;
  /** Token number, to be returned by the scanner.  */
  public static final int ONCE = 279;
  /** Token number, to be returned by the scanner.  */
  public static final int PRIVATE = 280;
  /** Token number, to be returned by the scanner.  */
  public static final int QUIT = 281;
  /** Token number, to be returned by the scanner.  */
  public static final int RETURN = 282;
  /** Token number, to be returned by the scanner.  */
  public static final int SAME = 283;
  /** Token number, to be returned by the scanner.  */
  public static final int SELF = 284;
  /** Token number, to be returned by the scanner.  */
  public static final int THEN = 285;
  /** Token number, to be returned by the scanner.  */
  public static final int TYPECASE = 286;
  /** Token number, to be returned by the scanner.  */
  public static final int VOID = 287;
  /** Token number, to be returned by the scanner.  */
  public static final int WHEN = 288;
  /** Token number, to be returned by the scanner.  */
  public static final int WHILE = 289;
  /** Token number, to be returned by the scanner.  */
  public static final int YIELD = 290;
  /** Token number, to be returned by the scanner.  */
  public static final int LPAREN = 291;
  /** Token number, to be returned by the scanner.  */
  public static final int RPAREN = 292;
  /** Token number, to be returned by the scanner.  */
  public static final int COMMA = 293;
  /** Token number, to be returned by the scanner.  */
  public static final int DOT = 294;
  /** Token number, to be returned by the scanner.  */
  public static final int SEMICOLON = 295;
  /** Token number, to be returned by the scanner.  */
  public static final int COLON = 296;
  /** Token number, to be returned by the scanner.  */
  public static final int PLUS = 297;
  /** Token number, to be returned by the scanner.  */
  public static final int MINUS = 298;
  /** Token number, to be returned by the scanner.  */
  public static final int ASTERISK = 299;
  /** Token number, to be returned by the scanner.  */
  public static final int SLASH = 300;
  /** Token number, to be returned by the scanner.  */
  public static final int PERCENT = 301;
  /** Token number, to be returned by the scanner.  */
  public static final int LESS = 302;
  /** Token number, to be returned by the scanner.  */
  public static final int LESSEQ = 303;
  /** Token number, to be returned by the scanner.  */
  public static final int EQUAL = 304;
  /** Token number, to be returned by the scanner.  */
  public static final int DISTINCT = 305;
  /** Token number, to be returned by the scanner.  */
  public static final int GREATER = 306;
  /** Token number, to be returned by the scanner.  */
  public static final int GREATEREQ = 307;
  /** Token number, to be returned by the scanner.  */
  public static final int TILDE = 308;
  /** Token number, to be returned by the scanner.  */
  public static final int ASSIGN = 309;
  /** Token number, to be returned by the scanner.  */
  public static final int SHARP = 310;
  /** Token number, to be returned by the scanner.  */
  public static final int UMINUS = 311;



  
  private Location yylloc (YYStack rhs, int n)
  {
    if (n > 0)
      return new Location (rhs.locationAt (n-1).begin, rhs.locationAt (0).end);
    else
      return new Location (rhs.locationAt (0).end);
  }

  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>Parser</tt>.
   */
  public interface Lexer {
    /**
     * Method to retrieve the beginning position of the last scanned token.
     * @return the position at which the last scanned token starts.  */
    Position getStartPos ();

    /**
     * Method to retrieve the ending position of the last scanned token.
     * @return the first position beyond the last scanned token.  */
    Position getEndPos ();

    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.  */
    Object getLVal ();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * and beginning/ending positions of the token.
     * @return the token identifier corresponding to the next token. */
    int yylex () throws java.io.IOException;

    /**
     * Entry point for error reporting.  Emits an error
     * referring to the given location in a user-defined way.
     *
     * @param loc The location of the element to which the
     *                error message is related
     * @param s The string for the error message.  */
     void yyerror (Location loc, String s);
  }

  /** The object doing lexical analysis for us.  */
  private Lexer yylexer;
  
  



  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public Parser (Lexer yylexer) {
    this.yylexer = yylexer;
    
  }

  private java.io.PrintStream yyDebugStream = System.err;

  /**
   * Return the <tt>PrintStream</tt> on which the debugging output is
   * printed.
   */
  public final java.io.PrintStream getDebugStream () { return yyDebugStream; }

  /**
   * Set the <tt>PrintStream</tt> on which the debug output is printed.
   * @param s The stream that is used for debugging output.
   */
  public final void setDebugStream(java.io.PrintStream s) { yyDebugStream = s; }

  private int yydebug = 0;

  /**
   * Answer the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   */
  public final int getDebugLevel() { return yydebug; }

  /**
   * Set the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   * @param level The verbosity level for debugging output.
   */
  public final void setDebugLevel(int level) { yydebug = level; }

  private final int yylex () throws java.io.IOException {
    return yylexer.yylex ();
  }
  protected final void yyerror (Location loc, String s) {
    yylexer.yyerror (loc, s);
  }

  
  protected final void yyerror (String s) {
    yylexer.yyerror ((Location)null, s);
  }
  protected final void yyerror (Position loc, String s) {
    yylexer.yyerror (new Location (loc), s);
  }

  protected final void yycdebug (String s) {
    if (yydebug > 0)
      yyDebugStream.println (s);
  }

  private final class YYStack {
    private int[] stateStack = new int[16];
    private Location[] locStack = new Location[16];
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push (int state, Object value			    , Location loc) {
      height++;
      if (size == height)
        {
	  int[] newStateStack = new int[size * 2];
	  System.arraycopy (stateStack, 0, newStateStack, 0, height);
	  stateStack = newStateStack;
	  
	  Location[] newLocStack = new Location[size * 2];
	  System.arraycopy (locStack, 0, newLocStack, 0, height);
	  locStack = newLocStack;

	  Object[] newValueStack = new Object[size * 2];
	  System.arraycopy (valueStack, 0, newValueStack, 0, height);
	  valueStack = newValueStack;

	  size *= 2;
	}

      stateStack[height] = state;
      locStack[height] = loc;
      valueStack[height] = value;
    }

    public final void pop () {
      pop (1);
    }

    public final void pop (int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (num > 0) {
	java.util.Arrays.fill (valueStack, height - num + 1, height + 1, null);
        java.util.Arrays.fill (locStack, height - num + 1, height + 1, null);
      }
      height -= num;
    }

    public final int stateAt (int i) {
      return stateStack[height - i];
    }

    public final Location locationAt (int i) {
      return locStack[height - i];
    }

    public final Object valueAt (int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print (java.io.PrintStream out)
    {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++)
        {
	  out.print (' ');
	  out.print (stateStack[i]);
        }
      out.println ();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).  */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).  */
  public static final int YYABORT = 1;

  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.  */
  public static final int YYERROR = 2;

  // Internal return codes that are not supported for user semantic
  // actions.
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;

  private int yyerrstatus_ = 0;

  /**
   * Return whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.  */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  private int yyaction (int yyn, YYStack yystack, int yylen) 
  {
    Object yyval;
    Location yyloc = yylloc (yystack, yylen);

    /* If YYLEN is nonzero, implement the default value of the action:
       `$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    if (yylen > 0)
      yyval = yystack.valueAt (yylen - 1);
    else
      yyval = yystack.valueAt (0);

    yy_reduce_print (yyn, yystack);

    switch (yyn)
      {
	  case 2:
  if (yyn == 2)
    /* Line 350 of lalr1.java  */
/* Line 99 of "parser.y"  */
    {
    SimpleNode program = new SimpleNode("program");
    program.addChild(((Node)(yystack.valueAt (1-(1)))));
    this.ast = new ASTree(program);
    return YYACCEPT;
 };
  break;
    

  case 3:
  if (yyn == 3)
    /* Line 350 of lalr1.java  */
/* Line 106 of "parser.y"  */
    {
    /* void */
 };
  break;
    

  case 4:
  if (yyn == 4)
    /* Line 350 of lalr1.java  */
/* Line 110 of "parser.y"  */
    {
    /* void */
};
  break;
    

  case 5:
  if (yyn == 5)
    /* Line 350 of lalr1.java  */
/* Line 114 of "parser.y"  */
    {
    ((Node)(yystack.valueAt (3-(1)))).addToList(((Node)(yystack.valueAt (3-(3)))));
    yyval = ((Node)(yystack.valueAt (3-(1))));
 };
  break;
    

  case 6:
  if (yyn == 6)
    /* Line 350 of lalr1.java  */
/* Line 119 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 7:
  if (yyn == 7)
    /* Line 350 of lalr1.java  */
/* Line 124 of "parser.y"  */
    {
    yyval = ((String)(yystack.valueAt (1-(1))));
};
  break;
    

  case 8:
  if (yyn == 8)
    /* Line 350 of lalr1.java  */
/* Line 128 of "parser.y"  */
    {
    yyval = "SAME";
};
  break;
    

  case 9:
  if (yyn == 9)
    /* Line 350 of lalr1.java  */
/* Line 132 of "parser.y"  */
    {
    yyval = ((String)(yystack.valueAt (1-(1))));
};
  break;
    

  case 10:
  if (yyn == 10)
    /* Line 350 of lalr1.java  */
/* Line 136 of "parser.y"  */
    {
    yyval = ((String)(yystack.valueAt (1-(1))));
};
  break;
    

  case 11:
  if (yyn == 11)
    /* Line 350 of lalr1.java  */
/* Line 140 of "parser.y"  */
    {
    ArgNode first = new ArgNode(((String)(yystack.valueAt (3-(1)))), ((String)(yystack.valueAt (3-(3)))));
    yyval = first;
};
  break;
    

  case 12:
  if (yyn == 12)
    /* Line 350 of lalr1.java  */
/* Line 145 of "parser.y"  */
    {
    ArgNode first = new ArgNode(((StringList)(yystack.valueAt (5-(1)))).car, ((String)(yystack.valueAt (5-(5)))));

    ArgNode aux;
    StringList iter = ((StringList)(yystack.valueAt (5-(1)))).cdr;
    ArgNode nw = new ArgNode(((String)(yystack.valueAt (5-(3)))),((String)(yystack.valueAt (5-(5)))));
    int i;

    while (iter != null) {
	aux = new ArgNode(iter.car, ((String)(yystack.valueAt (5-(5)))));
	first.addToList(aux);
	iter=iter.cdr;
    }
    first.addToList(nw);
    yyval = first;
};
  break;
    

  case 13:
  if (yyn == 13)
    /* Line 350 of lalr1.java  */
/* Line 162 of "parser.y"  */
    {
    StringList l = new StringList();

    l.car = ((String)(yystack.valueAt (1-(1))));
    l.cdr = null;
    yyval = l;
};
  break;
    

  case 14:
  if (yyn == 14)
    /* Line 350 of lalr1.java  */
/* Line 170 of "parser.y"  */
    {
    ((StringList)(yystack.valueAt (3-(1)))).append(((String)(yystack.valueAt (3-(3)))));
    yyval = ((StringList)(yystack.valueAt (3-(1))));
};
  break;
    

  case 15:
  if (yyn == 15)
    /* Line 350 of lalr1.java  */
/* Line 175 of "parser.y"  */
    {
    yyval = ((StringList)(yystack.valueAt (2-(2))));
};
  break;
    

  case 16:
  if (yyn == 16)
    /* Line 350 of lalr1.java  */
/* Line 179 of "parser.y"  */
    {
    //    $3.add(0, $1);
    StringList sl = new StringList();
    sl.car = ((String)(yystack.valueAt (3-(3))));
    sl.cdr = ((StringList)(yystack.valueAt (3-(1))));
    yyval = sl;
};
  break;
    

  case 17:
  if (yyn == 17)
    /* Line 350 of lalr1.java  */
/* Line 187 of "parser.y"  */
    {
    StringList sl = new StringList();
    sl.car = ((String)(yystack.valueAt (1-(1))));
    sl.cdr = null;
    yyval = sl;
};
  break;
    

  case 18:
  if (yyn == 18)
    /* Line 350 of lalr1.java  */
/* Line 194 of "parser.y"  */
    {
    ClassNode cl = new ClassNode(((String)(yystack.valueAt (1-(1)))));
    yyval = cl;
};
  break;
    

  case 19:
  if (yyn == 19)
    /* Line 350 of lalr1.java  */
/* Line 199 of "parser.y"  */
    {
    ClassNode cl = new ClassNode(((String)(yystack.valueAt (2-(1)))));
    cl.setSuperTypes(((StringList)(yystack.valueAt (2-(2)))).toList());
    yyval = cl;
};
  break;
    

  case 20:
  if (yyn == 20)
    /* Line 350 of lalr1.java  */
/* Line 206 of "parser.y"  */
    {
    ((Node)(yystack.valueAt (5-(2)))).addChild(((Node)(yystack.valueAt (5-(4)))));
    yyval = ((Node)(yystack.valueAt (5-(2))));
};
  break;
    

  case 21:
  if (yyn == 21)
    /* Line 350 of lalr1.java  */
/* Line 211 of "parser.y"  */
    {
    yyval = ((AttrNode)(yystack.valueAt (1-(1))));
};
  break;
    

  case 22:
  if (yyn == 22)
    /* Line 350 of lalr1.java  */
/* Line 215 of "parser.y"  */
    {
    yyval = ((MethodNode)(yystack.valueAt (1-(1))));
};
  break;
    

  case 23:
  if (yyn == 23)
    /* Line 350 of lalr1.java  */
/* Line 219 of "parser.y"  */
    {
    yyval = ((IterNode)(yystack.valueAt (1-(1))));
};
  break;
    

  case 24:
  if (yyn == 24)
    /* Line 350 of lalr1.java  */
/* Line 223 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 25:
  if (yyn == 25)
    /* Line 350 of lalr1.java  */
/* Line 227 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 26:
  if (yyn == 26)
    /* Line 350 of lalr1.java  */
/* Line 231 of "parser.y"  */
    {
    ((Node)(yystack.valueAt (3-(1)))).addToList(((Node)(yystack.valueAt (3-(3)))));
};
  break;
    

  case 27:
  if (yyn == 27)
    /* Line 350 of lalr1.java  */
/* Line 235 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (2-(1))));
};
  break;
    

  case 28:
  if (yyn == 28)
    /* Line 350 of lalr1.java  */
/* Line 239 of "parser.y"  */
    {
    /* void */
};
  break;
    

  case 29:
  if (yyn == 29)
    /* Line 350 of lalr1.java  */
/* Line 244 of "parser.y"  */
    {
    yyval = ((AttrNode)(yystack.valueAt (1-(1))));
};
  break;
    

  case 30:
  if (yyn == 30)
    /* Line 350 of lalr1.java  */
/* Line 248 of "parser.y"  */
    {
    ((AttrNode)(yystack.valueAt (2-(2)))).setPrivate();
    yyval = ((AttrNode)(yystack.valueAt (2-(2))));
};
  break;
    

  case 31:
  if (yyn == 31)
    /* Line 350 of lalr1.java  */
/* Line 253 of "parser.y"  */
    {
    AttrNode first = new AttrNode(((StringList)(yystack.valueAt (4-(2)))).car, ((String)(yystack.valueAt (4-(4)))));
    AttrNode aux;
    StringList iter = ((StringList)(yystack.valueAt (4-(2)))).cdr;

    while(iter != null) {
	aux = new AttrNode(iter.car, ((String)(yystack.valueAt (4-(4)))));
	first.addToList(aux);
	iter = iter.cdr;
    }

    yyval = first;
};
  break;
    

  case 32:
  if (yyn == 32)
    /* Line 350 of lalr1.java  */
/* Line 267 of "parser.y"  */
    {
    yyval = ((ArgNode)(yystack.valueAt (1-(1))));
};
  break;
    

  case 33:
  if (yyn == 33)
    /* Line 350 of lalr1.java  */
/* Line 271 of "parser.y"  */
    {
    ((ArgNode)(yystack.valueAt (3-(1)))).addToList(((ArgNode)(yystack.valueAt (3-(3)))));
    yyval = ((ArgNode)(yystack.valueAt (3-(1))));
};
  break;
    

  case 34:
  if (yyn == 34)
    /* Line 350 of lalr1.java  */
/* Line 276 of "parser.y"  */
    {
    MethodNode aux = new MethodNode(((String)(yystack.valueAt (4-(1)))), null);
    SimpleNode body = new SimpleNode("body");
    aux.addChild(body);
    body.addChild(((Node)(yystack.valueAt (4-(3)))));
    yyval = aux;
};
  break;
    

  case 35:
  if (yyn == 35)
    /* Line 350 of lalr1.java  */
/* Line 284 of "parser.y"  */
    {
    MethodNode aux = new MethodNode(((String)(yystack.valueAt (7-(1)))), null);
    SimpleNode body = new SimpleNode("body");
    SimpleNode args = new SimpleNode("arguments");
    args.addChild(((ArgNode)(yystack.valueAt (7-(3)))));
    body.addChild(((Node)(yystack.valueAt (7-(6)))));
    aux.addChild(args);
    aux.addChild(body);
    yyval = aux;
};
  break;
    

  case 36:
  if (yyn == 36)
    /* Line 350 of lalr1.java  */
/* Line 295 of "parser.y"  */
    {
    MethodNode aux = new MethodNode(((String)(yystack.valueAt (6-(1)))), ((String)(yystack.valueAt (6-(3)))));
    SimpleNode body = new SimpleNode("body");
    aux.addChild(body);
    body.addChild(((Node)(yystack.valueAt (6-(5)))));
    yyval = aux;
};
  break;
    

  case 37:
  if (yyn == 37)
    /* Line 350 of lalr1.java  */
/* Line 303 of "parser.y"  */
    {
    MethodNode aux = new MethodNode(((String)(yystack.valueAt (9-(1)))), ((String)(yystack.valueAt (9-(6)))));
    SimpleNode body = new SimpleNode("body");
    SimpleNode args = new SimpleNode("arguments");
    args.addChild(((ArgNode)(yystack.valueAt (9-(3)))));
    body.addChild(((Node)(yystack.valueAt (9-(8)))));
    aux.addChild(args);
    aux.addChild(body);
    yyval = aux;
};
  break;
    

  case 38:
  if (yyn == 38)
    /* Line 350 of lalr1.java  */
/* Line 313 of "parser.y"  */
    {
    yyval = ((MethodNode)(yystack.valueAt (1-(1))));
};
  break;
    

  case 39:
  if (yyn == 39)
    /* Line 350 of lalr1.java  */
/* Line 317 of "parser.y"  */
    {
    MethodNode aux = ((MethodNode)(yystack.valueAt (2-(2))));
    aux.setPrivate();
    yyval = aux;
};
  break;
    

  case 40:
  if (yyn == 40)
    /* Line 350 of lalr1.java  */
/* Line 323 of "parser.y"  */
    {
    yyval = ((ArgNode)(yystack.valueAt (1-(1))));
};
  break;
    

  case 41:
  if (yyn == 41)
    /* Line 350 of lalr1.java  */
/* Line 327 of "parser.y"  */
    {
    ((ArgNode)(yystack.valueAt (2-(2)))).setOnce();
    yyval = ((ArgNode)(yystack.valueAt (2-(2))));
};
  break;
    

  case 42:
  if (yyn == 42)
    /* Line 350 of lalr1.java  */
/* Line 331 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 43:
  if (yyn == 43)
    /* Line 350 of lalr1.java  */
/* Line 335 of "parser.y"  */
    {
    ((Node)(yystack.valueAt (3-(1)))).setRightBrother(((Node)(yystack.valueAt (3-(3)))));
    yyval = ((Node)(yystack.valueAt (3-(1))));
};
  break;
    

  case 44:
  if (yyn == 44)
    /* Line 350 of lalr1.java  */
/* Line 340 of "parser.y"  */
    {
    IterNode in = new IterNode(((String)(yystack.valueAt (4-(1)))));
    SimpleNode body = new SimpleNode("body");
    body.addChild(((Node)(yystack.valueAt (4-(3)))));
    in.addChild(body);
    yyval = in;
};
  break;
    

  case 45:
  if (yyn == 45)
    /* Line 350 of lalr1.java  */
/* Line 348 of "parser.y"  */
    {
    IterNode in = new IterNode(((String)(yystack.valueAt (7-(1)))));
    SimpleNode args = new SimpleNode("arguments");
    args.addChild(((Node)(yystack.valueAt (7-(3)))));
    SimpleNode body = new SimpleNode("body");
    body.addChild(((Node)(yystack.valueAt (7-(6)))));
    in.addChild(args);
    in.addChild(body);
    yyval = in;
};
  break;
    

  case 46:
  if (yyn == 46)
    /* Line 350 of lalr1.java  */
/* Line 359 of "parser.y"  */
    {
    IterNode in = new IterNode(((String)(yystack.valueAt (6-(1)))), ((String)(yystack.valueAt (6-(3)))));
    SimpleNode body = new SimpleNode("body");
    body.addChild(((Node)(yystack.valueAt (6-(5)))));
    in.addChild(body);
    yyval = in;
};
  break;
    

  case 47:
  if (yyn == 47)
    /* Line 350 of lalr1.java  */
/* Line 367 of "parser.y"  */
    {
    IterNode in = new IterNode(((String)(yystack.valueAt (9-(1)))), ((String)(yystack.valueAt (9-(6)))));
    SimpleNode args = new SimpleNode("arguments");
    args.addChild(((Node)(yystack.valueAt (9-(3)))));
    SimpleNode body = new SimpleNode("body");
    body.addChild(((Node)(yystack.valueAt (9-(8)))));
    in.addChild(args);
    in.addChild(body);
    yyval = in;
};
  break;
    

  case 48:
  if (yyn == 48)
    /* Line 350 of lalr1.java  */
/* Line 378 of "parser.y"  */
    {
    yyval = ((IterNode)(yystack.valueAt (1-(1))));
};
  break;
    

  case 49:
  if (yyn == 49)
    /* Line 350 of lalr1.java  */
/* Line 382 of "parser.y"  */
    {
    ((IterNode)(yystack.valueAt (2-(2)))).setPrivate();
    yyval = ((IterNode)(yystack.valueAt (2-(2))));
};
  break;
    

  case 50:
  if (yyn == 50)
    /* Line 350 of lalr1.java  */
/* Line 386 of "parser.y"  */
    {
    TransfNode tn = new TransfNode(((String)(yystack.valueAt (3-(1)))), ((String)(yystack.valueAt (3-(3)))));
    yyval = tn;
};
  break;
    

  case 51:
  if (yyn == 51)
    /* Line 350 of lalr1.java  */
/* Line 391 of "parser.y"  */
    {
    TransfNode tn = new TransfNode(((String)(yystack.valueAt (3-(1)))), ((String)(yystack.valueAt (3-(3)))));
    yyval = tn;
};
  break;
    

  case 52:
  if (yyn == 52)
    /* Line 350 of lalr1.java  */
/* Line 396 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 53:
  if (yyn == 53)
    /* Line 350 of lalr1.java  */
/* Line 400 of "parser.y"  */
    {
    ((Node)(yystack.valueAt (3-(1)))).setRightBrother(((Node)(yystack.valueAt (3-(3)))));
    yyval = ((Node)(yystack.valueAt (3-(1))));
};
  break;
    

  case 54:
  if (yyn == 54)
    /* Line 350 of lalr1.java  */
/* Line 405 of "parser.y"  */
    {
    IncludeNode in = new IncludeNode(((String)(yystack.valueAt (3-(2)))));
    in.addChild(((Node)(yystack.valueAt (3-(3)))));
    yyval = in;
};
  break;
    

  case 55:
  if (yyn == 55)
    /* Line 350 of lalr1.java  */
/* Line 411 of "parser.y"  */
    {
    IncludeNode in = new IncludeNode(((String)(yystack.valueAt (2-(2)))));
    yyval = in;
};
  break;
    

  case 56:
  if (yyn == 56)
    /* Line 350 of lalr1.java  */
/* Line 417 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 57:
  if (yyn == 57)
    /* Line 350 of lalr1.java  */
/* Line 421 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (2-(2))));
};
  break;
    

  case 58:
  if (yyn == 58)
    /* Line 350 of lalr1.java  */
/* Line 425 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (2-(1))));
};
  break;
    

  case 59:
  if (yyn == 59)
    /* Line 350 of lalr1.java  */
/* Line 429 of "parser.y"  */
    {
    ((Node)(yystack.valueAt (3-(1)))).addToList(((Node)(yystack.valueAt (3-(3)))));
    yyval = ((Node)(yystack.valueAt (3-(1))));
};
  break;
    

  case 60:
  if (yyn == 60)
    /* Line 350 of lalr1.java  */
/* Line 435 of "parser.y"  */
    {
    yyval = ((ArgNode)(yystack.valueAt (1-(1))));
};
  break;
    

  case 61:
  if (yyn == 61)
    /* Line 350 of lalr1.java  */
/* Line 439 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 62:
  if (yyn == 62)
    /* Line 350 of lalr1.java  */
/* Line 443 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 63:
  if (yyn == 63)
    /* Line 350 of lalr1.java  */
/* Line 447 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 64:
  if (yyn == 64)
    /* Line 350 of lalr1.java  */
/* Line 451 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 65:
  if (yyn == 65)
    /* Line 350 of lalr1.java  */
/* Line 455 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 66:
  if (yyn == 66)
    /* Line 350 of lalr1.java  */
/* Line 459 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 67:
  if (yyn == 67)
    /* Line 350 of lalr1.java  */
/* Line 463 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 68:
  if (yyn == 68)
    /* Line 350 of lalr1.java  */
/* Line 467 of "parser.y"  */
    {
    SimpleNode sn = new SimpleNode("quit");
    yyval = sn;
};
  break;
    

  case 69:
  if (yyn == 69)
    /* Line 350 of lalr1.java  */
/* Line 472 of "parser.y"  */
    {
    AssignNode as = new AssignNode();
    as.addChild(((Node)(yystack.valueAt (3-(1)))));
    as.addChild(((Node)(yystack.valueAt (3-(3)))));
    yyval = as;
};
  break;
    

  case 70:
  if (yyn == 70)
    /* Line 350 of lalr1.java  */
/* Line 479 of "parser.y"  */
    {
    AssignNode as = new AssignNode(((String)(yystack.valueAt (4-(1)))));
    as.addChild(((Node)(yystack.valueAt (4-(4)))));
    yyval = as;
};
  break;
    

  case 71:
  if (yyn == 71)
    /* Line 350 of lalr1.java  */
/* Line 485 of "parser.y"  */
    {
    AssignNode as = new AssignNode(((String)(yystack.valueAt (5-(1)))), ((String)(yystack.valueAt (5-(3)))));
    as.addChild(((Node)(yystack.valueAt (5-(5)))));
    yyval = as;
};
  break;
    

  case 72:
  if (yyn == 72)
    /* Line 350 of lalr1.java  */
/* Line 491 of "parser.y"  */
    {
    SimpleNode cond = new SimpleNode("condition");
    cond.addChild(((Node)(yystack.valueAt (4-(2)))));
    SimpleNode body = new SimpleNode("body");
    body.addChild(((Node)(yystack.valueAt (4-(4)))));
    cond.addChild(body);

    yyval = cond;
};
  break;
    

  case 73:
  if (yyn == 73)
    /* Line 350 of lalr1.java  */
/* Line 501 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 74:
  if (yyn == 74)
    /* Line 350 of lalr1.java  */
/* Line 505 of "parser.y"  */
    {
    ((Node)(yystack.valueAt (2-(1)))).setRightBrother(((Node)(yystack.valueAt (2-(2)))));
    yyval = ((Node)(yystack.valueAt (2-(1))));
};
  break;
    

  case 75:
  if (yyn == 75)
    /* Line 350 of lalr1.java  */
/* Line 511 of "parser.y"  */
    {
    SimpleNode sn = new SimpleNode("if");
    SimpleNode cond = new SimpleNode("condition");
    cond.addChild(((Node)(yystack.valueAt (5-(2)))));
    SimpleNode body = new SimpleNode("body");
    cond.addChild(body);
    body.addChild(((Node)(yystack.valueAt (5-(4)))));
    sn.addChild(cond);
    yyval = sn;
};
  break;
    

  case 76:
  if (yyn == 76)
    /* Line 350 of lalr1.java  */
/* Line 522 of "parser.y"  */
    {
    SimpleNode sn = new SimpleNode("if");
    SimpleNode cond = new SimpleNode("condition");
    cond.addChild(((Node)(yystack.valueAt (6-(2)))));
    SimpleNode body = new SimpleNode("body");
    cond.addChild(body);
    body.addChild(((Node)(yystack.valueAt (6-(4)))));

    cond.setRightBrother(((Node)(yystack.valueAt (6-(5)))));

    sn.addChild(cond);
    yyval = sn;
};
  break;
    

  case 77:
  if (yyn == 77)
    /* Line 350 of lalr1.java  */
/* Line 536 of "parser.y"  */
    {
    SimpleNode sn = new SimpleNode("if");
    SimpleNode cond = new SimpleNode("condition");
    cond.addChild(((Node)(yystack.valueAt (7-(2)))));
    SimpleNode body = new SimpleNode("body");
    cond.addChild(body);
    body.addChild(((Node)(yystack.valueAt (7-(4)))));
    SimpleNode els = new SimpleNode("else");
    els.addChild(((Node)(yystack.valueAt (7-(6)))));
    cond.addToList(els);
    sn.addChild(cond);
    yyval = sn;
};
  break;
    

  case 78:
  if (yyn == 78)
    /* Line 350 of lalr1.java  */
/* Line 550 of "parser.y"  */
    {
    SimpleNode sn = new SimpleNode("if");
    SimpleNode cond = new SimpleNode("condition");
    cond.addChild(((Node)(yystack.valueAt (8-(2)))));
    SimpleNode body = new SimpleNode("body");
    cond.addChild(body);
    body.addChild(((Node)(yystack.valueAt (8-(4)))));
    cond.setRightBrother(((Node)(yystack.valueAt (8-(5)))));
    SimpleNode els = new SimpleNode("else");
    els.addChild(((Node)(yystack.valueAt (8-(7)))));
    cond.addToList(els);
    sn.addChild(cond);
    yyval = sn;
};
  break;
    

  case 79:
  if (yyn == 79)
    /* Line 350 of lalr1.java  */
/* Line 565 of "parser.y"  */
    {
    SimpleNode sn = new SimpleNode("return");
    yyval = sn;
};
  break;
    

  case 80:
  if (yyn == 80)
    /* Line 350 of lalr1.java  */
/* Line 570 of "parser.y"  */
    {
    SimpleNode sn = new SimpleNode("return");
    sn.addChild(((Node)(yystack.valueAt (2-(2)))));
    yyval = sn;
};
  break;
    

  case 81:
  if (yyn == 81)
    /* Line 350 of lalr1.java  */
/* Line 576 of "parser.y"  */
    {
    SimpleNode sn = new SimpleNode(((String)(yystack.valueAt (4-(2)))));
    sn.addChild(((Node)(yystack.valueAt (4-(4)))));
    yyval = sn;
};
  break;
    

  case 82:
  if (yyn == 82)
    /* Line 350 of lalr1.java  */
/* Line 582 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 83:
  if (yyn == 83)
    /* Line 350 of lalr1.java  */
/* Line 586 of "parser.y"  */
    {
    ((Node)(yystack.valueAt (2-(1)))).addToList(((Node)(yystack.valueAt (2-(2)))));
    yyval = ((Node)(yystack.valueAt (2-(1))));
};
  break;
    

  case 84:
  if (yyn == 84)
    /* Line 350 of lalr1.java  */
/* Line 591 of "parser.y"  */
    {
    TypecaseNode sn = new TypecaseNode(((String)(yystack.valueAt (4-(2)))));
    sn.addChild(((Node)(yystack.valueAt (4-(3)))));
    yyval = sn;    
};
  break;
    

  case 85:
  if (yyn == 85)
    /* Line 350 of lalr1.java  */
/* Line 597 of "parser.y"  */
    {
    TypecaseNode sn = new TypecaseNode(((String)(yystack.valueAt (6-(2)))));
    SimpleNode els = new SimpleNode("else");
    els.addChild(((Node)(yystack.valueAt (6-(5)))));
    ((Node)(yystack.valueAt (6-(3)))).addToList(els);
    sn.addChild(((Node)(yystack.valueAt (6-(3)))));
    yyval = sn;
};
  break;
    

  case 86:
  if (yyn == 86)
    /* Line 350 of lalr1.java  */
/* Line 606 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 87:
  if (yyn == 87)
    /* Line 350 of lalr1.java  */
/* Line 610 of "parser.y"  */
    {
    LiteralNode ln = new LiteralNode("BOOL", ((Boolean)(yystack.valueAt (1-(1)))).toString());
    yyval = ln;
};
  break;
    

  case 88:
  if (yyn == 88)
    /* Line 350 of lalr1.java  */
/* Line 615 of "parser.y"  */
    {
    LiteralNode ln = new LiteralNode("CHAR", "\'"+((Character)(yystack.valueAt (1-(1))))+"\'");
    yyval = ln;
};
  break;
    

  case 89:
  if (yyn == 89)
    /* Line 350 of lalr1.java  */
/* Line 620 of "parser.y"  */
    {
    LiteralNode ln = new LiteralNode("STR", "\""+((String)(yystack.valueAt (1-(1))))+"\"");
    yyval = ln;
};
  break;
    

  case 90:
  if (yyn == 90)
    /* Line 350 of lalr1.java  */
/* Line 625 of "parser.y"  */
    {
    LiteralNode ln = new LiteralNode("INT", ((Integer)(yystack.valueAt (1-(1))))+"");
    yyval = ln;
};
  break;
    

  case 91:
  if (yyn == 91)
    /* Line 350 of lalr1.java  */
/* Line 630 of "parser.y"  */
    {
    SimpleNode sn = new SimpleNode("self");
    yyval = sn;
};
  break;
    

  case 92:
  if (yyn == 92)
    /* Line 350 of lalr1.java  */
/* Line 635 of "parser.y"  */
    {
    LocalNode ln = new LocalNode(((String)(yystack.valueAt (1-(1)))));
    yyval = ln;
};
  break;
    

  case 93:
  if (yyn == 93)
    /* Line 350 of lalr1.java  */
/* Line 640 of "parser.y"  */
    {
    yyval= ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 94:
  if (yyn == 94)
    /* Line 350 of lalr1.java  */
/* Line 644 of "parser.y"  */
    {
    SimpleNode sn = new SimpleNode("void");
    yyval = sn;
};
  break;
    

  case 95:
  if (yyn == 95)
    /* Line 350 of lalr1.java  */
/* Line 649 of "parser.y"  */
    {
    SimpleNode sn = new SimpleNode("void");
    sn.addChild(((Node)(yystack.valueAt (4-(3)))));
    yyval = sn;
};
  break;
    

  case 96:
  if (yyn == 96)
    /* Line 350 of lalr1.java  */
/* Line 655 of "parser.y"  */
    {
    SimpleNode sn = new SimpleNode("new");
    yyval = sn;
};
  break;
    

  case 97:
  if (yyn == 97)
    /* Line 350 of lalr1.java  */
/* Line 660 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 98:
  if (yyn == 98)
    /* Line 350 of lalr1.java  */
/* Line 664 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 99:
  if (yyn == 99)
    /* Line 350 of lalr1.java  */
/* Line 668 of "parser.y"  */
    {
    SimpleNode sn = new SimpleNode("while");
    sn.addChild(((Node)(yystack.valueAt (4-(3)))));
    yyval = sn;
};
  break;
    

  case 100:
  if (yyn == 100)
    /* Line 350 of lalr1.java  */
/* Line 674 of "parser.y"  */
    {
    SimpleNode sn = new SimpleNode("break");
    yyval = sn;
};
  break;
    

  case 101:
  if (yyn == 101)
    /* Line 350 of lalr1.java  */
/* Line 679 of "parser.y"  */
    {
    yyval = ((String)(yystack.valueAt (1-(1))));
};
  break;
    

  case 102:
  if (yyn == 102)
    /* Line 350 of lalr1.java  */
/* Line 683 of "parser.y"  */
    {
    yyval = ((String)(yystack.valueAt (1-(1))));
};
  break;
    

  case 103:
  if (yyn == 103)
    /* Line 350 of lalr1.java  */
/* Line 687 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (1-(1))));
};
  break;
    

  case 104:
  if (yyn == 104)
    /* Line 350 of lalr1.java  */
/* Line 691 of "parser.y"  */
    {
    ((Node)(yystack.valueAt (3-(1)))).setRightBrother(((Node)(yystack.valueAt (3-(3)))));
    yyval = ((Node)(yystack.valueAt (3-(1))));
};
  break;
    

  case 105:
  if (yyn == 105)
    /* Line 350 of lalr1.java  */
/* Line 696 of "parser.y"  */
    {
    CallNode cd = new CallNode(((String)(yystack.valueAt (3-(3)))));
    SimpleNode caller = new SimpleNode("caller");
    caller.addChild(((Node)(yystack.valueAt (3-(1)))));
    cd.addChild(caller);
    yyval = cd;
};
  break;
    

  case 106:
  if (yyn == 106)
    /* Line 350 of lalr1.java  */
/* Line 704 of "parser.y"  */
    {
    CallNode cd = new CallNode(((String)(yystack.valueAt (6-(3)))));
    SimpleNode caller = new SimpleNode("caller");
    SimpleNode args = new SimpleNode("arguments");
    caller.addChild(((Node)(yystack.valueAt (6-(1)))));
    args.addChild(((Node)(yystack.valueAt (6-(5)))));
    cd.addChild(caller);
    cd.addChild(args);
    yyval = cd;

};
  break;
    

  case 107:
  if (yyn == 107)
    /* Line 350 of lalr1.java  */
/* Line 716 of "parser.y"  */
    {
    CreateNode cn = new CreateNode("");
    yyval = cn;
};
  break;
    

  case 108:
  if (yyn == 108)
    /* Line 350 of lalr1.java  */
/* Line 721 of "parser.y"  */
    {
    CreateNode cn = new CreateNode(((String)(yystack.valueAt (2-(2)))));
    yyval = cn;
};
  break;
    

  case 109:
  if (yyn == 109)
    /* Line 350 of lalr1.java  */
/* Line 726 of "parser.y"  */
    {
    CreateNode cn = new CreateNode(((String)(yystack.valueAt (5-(2)))));
    cn.addChild(((Node)(yystack.valueAt (5-(4)))));
    yyval = cn;
};
  break;
    

  case 110:
  if (yyn == 110)
    /* Line 350 of lalr1.java  */
/* Line 732 of "parser.y"  */
    {
    CreateNode cn = new CreateNode("");
    cn.addChild(((Node)(yystack.valueAt (4-(3)))));
    yyval = cn;
};
  break;
    

  case 111:
  if (yyn == 111)
    /* Line 350 of lalr1.java  */
/* Line 748 of "parser.y"  */
    {
    SimpleNode sn = new SimpleNode("and");
    sn.addChild(((Node)(yystack.valueAt (3-(1)))));
    sn.addChild(((Node)(yystack.valueAt (3-(3)))));
    yyval = sn;
};
  break;
    

  case 112:
  if (yyn == 112)
    /* Line 350 of lalr1.java  */
/* Line 755 of "parser.y"  */
    {
    SimpleNode sn = new SimpleNode("or");
    sn.addChild(((Node)(yystack.valueAt (3-(1)))));
    sn.addChild(((Node)(yystack.valueAt (3-(3)))));
    yyval = sn;
};
  break;
    

  case 113:
  if (yyn == 113)
    /* Line 350 of lalr1.java  */
/* Line 763 of "parser.y"  */
    {
  BinaryNode bn = new BinaryNode ( "+" );
  bn.addChild(((Node)(yystack.valueAt (3-(1)))));
  bn.addChild(((Node)(yystack.valueAt (3-(3)))));
  yyval = bn;
};
  break;
    

  case 114:
  if (yyn == 114)
    /* Line 350 of lalr1.java  */
/* Line 769 of "parser.y"  */
    {
  BinaryNode bn = new BinaryNode ( "-" );
  bn.addChild(((Node)(yystack.valueAt (3-(1)))));
  bn.addChild(((Node)(yystack.valueAt (3-(3)))));
  yyval = bn;
};
  break;
    

  case 115:
  if (yyn == 115)
    /* Line 350 of lalr1.java  */
/* Line 775 of "parser.y"  */
    {
  BinaryNode bn = new BinaryNode ( "*" );
  bn.addChild(((Node)(yystack.valueAt (3-(1)))));
  bn.addChild(((Node)(yystack.valueAt (3-(3)))));
  yyval = bn;
};
  break;
    

  case 116:
  if (yyn == 116)
    /* Line 350 of lalr1.java  */
/* Line 781 of "parser.y"  */
    {
  BinaryNode bn = new BinaryNode ( "/" );
  bn.addChild(((Node)(yystack.valueAt (3-(1)))));
  bn.addChild(((Node)(yystack.valueAt (3-(3)))));
  yyval = bn;
};
  break;
    

  case 117:
  if (yyn == 117)
    /* Line 350 of lalr1.java  */
/* Line 787 of "parser.y"  */
    {
  BinaryNode bn = new BinaryNode ( "%" );
  bn.addChild(((Node)(yystack.valueAt (3-(1)))));
  bn.addChild(((Node)(yystack.valueAt (3-(3)))));
  yyval = bn;
};
  break;
    

  case 118:
  if (yyn == 118)
    /* Line 350 of lalr1.java  */
/* Line 793 of "parser.y"  */
    {
  BinaryNode bn = new BinaryNode ( "<" );
  bn.addChild(((Node)(yystack.valueAt (3-(1)))));
  bn.addChild(((Node)(yystack.valueAt (3-(3)))));
  yyval = bn;
};
  break;
    

  case 119:
  if (yyn == 119)
    /* Line 350 of lalr1.java  */
/* Line 799 of "parser.y"  */
    {
  BinaryNode bn = new BinaryNode ( "<=" );
  bn.addChild(((Node)(yystack.valueAt (3-(1)))));
  bn.addChild(((Node)(yystack.valueAt (3-(3)))));
  yyval = bn;
};
  break;
    

  case 120:
  if (yyn == 120)
    /* Line 350 of lalr1.java  */
/* Line 805 of "parser.y"  */
    {
  BinaryNode bn = new BinaryNode ( "=" );
  bn.addChild(((Node)(yystack.valueAt (3-(1)))));
  bn.addChild(((Node)(yystack.valueAt (3-(3)))));
  yyval = bn;
};
  break;
    

  case 121:
  if (yyn == 121)
    /* Line 350 of lalr1.java  */
/* Line 811 of "parser.y"  */
    {
  BinaryNode bn = new BinaryNode ( "/=" );
  bn.addChild(((Node)(yystack.valueAt (3-(1)))));
  bn.addChild(((Node)(yystack.valueAt (3-(3)))));
  yyval = bn;
};
  break;
    

  case 122:
  if (yyn == 122)
    /* Line 350 of lalr1.java  */
/* Line 817 of "parser.y"  */
    {
  BinaryNode bn = new BinaryNode ( ">" );
  bn.addChild(((Node)(yystack.valueAt (3-(1)))));
  bn.addChild(((Node)(yystack.valueAt (3-(3)))));
  yyval = bn;
};
  break;
    

  case 123:
  if (yyn == 123)
    /* Line 350 of lalr1.java  */
/* Line 823 of "parser.y"  */
    {
  BinaryNode bn = new BinaryNode ( ">=" );
  bn.addChild(((Node)(yystack.valueAt (3-(1)))));
  bn.addChild(((Node)(yystack.valueAt (3-(3)))));
  yyval = bn;
};
  break;
    

  case 124:
  if (yyn == 124)
    /* Line 350 of lalr1.java  */
/* Line 830 of "parser.y"  */
    { 
    UnaryNode un = new UnaryNode("-");
    un.addChild(((Node)(yystack.valueAt (2-(2)))));
    yyval = un;
};
  break;
    

  case 125:
  if (yyn == 125)
    /* Line 350 of lalr1.java  */
/* Line 836 of "parser.y"  */
    {
    yyval = ((Node)(yystack.valueAt (3-(2))));
};
  break;
    

  case 126:
  if (yyn == 126)
    /* Line 350 of lalr1.java  */
/* Line 840 of "parser.y"  */
    {
    UnaryNode un = new UnaryNode("~");
    un.addChild(((Node)(yystack.valueAt (2-(2)))));
    yyval = un;
};
  break;
    

  case 127:
  if (yyn == 127)
    /* Line 350 of lalr1.java  */
/* Line 846 of "parser.y"  */
    {
    SimpleNode sn = new SimpleNode("loop");
    sn.addChild(((Node)(yystack.valueAt (3-(2)))));
    yyval = sn;
};
  break;
    

  case 128:
  if (yyn == 128)
    /* Line 350 of lalr1.java  */
/* Line 852 of "parser.y"  */
    {
    SimpleNode sn = new SimpleNode("yield");
    yyval = sn;
};
  break;
    

  case 129:
  if (yyn == 129)
    /* Line 350 of lalr1.java  */
/* Line 857 of "parser.y"  */
    {
    SimpleNode sn = new SimpleNode("yield");
    sn.addChild(((Node)(yystack.valueAt (2-(2)))));
    yyval = sn;
};
  break;
    


/* Line 350 of lalr1.java  */
/* Line 1992 of "Parser.java"  */
	default: break;
      }

    yy_symbol_print ("-> $$ =", yyr1_[yyn], yyval, yyloc);

    yystack.pop (yylen);
    yylen = 0;

    /* Shift the result of the reduction.  */
    yyn = yyr1_[yyn];
    int yystate = yypgoto_[yyn - yyntokens_] + yystack.stateAt (0);
    if (0 <= yystate && yystate <= yylast_
	&& yycheck_[yystate] == yystack.stateAt (0))
      yystate = yytable_[yystate];
    else
      yystate = yydefgoto_[yyn - yyntokens_];

    yystack.push (yystate, yyval, yyloc);
    return YYNEWSTATE;
  }

  /* Return YYSTR after stripping away unnecessary quotes and
     backslashes, so that it's suitable for yyerror.  The heuristic is
     that double-quoting is unnecessary unless the string contains an
     apostrophe, a comma, or backslash (other than backslash-backslash).
     YYSTR is taken from yytname.  */
  private final String yytnamerr_ (String yystr)
  {
    if (yystr.charAt (0) == '"')
      {
        StringBuffer yyr = new StringBuffer ();
        strip_quotes: for (int i = 1; i < yystr.length (); i++)
          switch (yystr.charAt (i))
            {
            case '\'':
            case ',':
              break strip_quotes;

            case '\\':
	      if (yystr.charAt(++i) != '\\')
                break strip_quotes;
              /* Fall through.  */
            default:
              yyr.append (yystr.charAt (i));
              break;

            case '"':
              return yyr.toString ();
            }
      }
    else if (yystr.equals ("$end"))
      return "end of input";

    return yystr;
  }

  /*--------------------------------.
  | Print this symbol on YYOUTPUT.  |
  `--------------------------------*/

  private void yy_symbol_print (String s, int yytype,
			         Object yyvaluep				 , Object yylocationp)
  {
    if (yydebug > 0)
    yycdebug (s + (yytype < yyntokens_ ? " token " : " nterm ")
	      + yytname_[yytype] + " ("
	      + yylocationp + ": "
	      + (yyvaluep == null ? "(null)" : yyvaluep.toString ()) + ")");
  }

  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
  public boolean parse () throws java.io.IOException
  {
    /// Lookahead and lookahead in internal form.
    int yychar = yyempty_;
    int yytoken = 0;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;

    YYStack yystack = new YYStack ();

    /* Error handling.  */
    int yynerrs_ = 0;
    /// The location where the error started.
    Location yyerrloc = null;

    /// Location of the lookahead.
    Location yylloc = new Location (null, null);

    /// @$.
    Location yyloc;

    /// Semantic value of the lookahead.
    Object yylval = null;

    yycdebug ("Starting parse\n");
    yyerrstatus_ = 0;


    /* Initialize the stack.  */
    yystack.push (yystate, yylval, yylloc);

    int label = YYNEWSTATE;
    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
	   pushed when we come here.  */
      case YYNEWSTATE:
        yycdebug ("Entering state " + yystate + "\n");
        if (yydebug > 0)
          yystack.print (yyDebugStream);

        /* Accept?  */
        if (yystate == yyfinal_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yy_pact_value_is_default_ (yyn))
          {
            label = YYDEFAULT;
	    break;
          }

        /* Read a lookahead token.  */
        if (yychar == yyempty_)
          {
	    yycdebug ("Reading a token: ");
	    yychar = yylex ();
            
	    yylloc = new Location(yylexer.getStartPos (),
				            yylexer.getEndPos ());
            yylval = yylexer.getLVal ();
          }

        /* Convert token to internal form.  */
        if (yychar <= EOF)
          {
	    yychar = yytoken = EOF;
	    yycdebug ("Now at end of input.\n");
          }
        else
          {
	    yytoken = yytranslate_ (yychar);
	    yy_symbol_print ("Next token is", yytoken,
			     yylval, yylloc);
          }

        /* If the proper action on seeing token YYTOKEN is to reduce or to
           detect an error, take that action.  */
        yyn += yytoken;
        if (yyn < 0 || yylast_ < yyn || yycheck_[yyn] != yytoken)
          label = YYDEFAULT;

        /* <= 0 means reduce or error.  */
        else if ((yyn = yytable_[yyn]) <= 0)
          {
	    if (yy_table_value_is_error_ (yyn))
	      label = YYERRLAB;
	    else
	      {
	        yyn = -yyn;
	        label = YYREDUCE;
	      }
          }

        else
          {
            /* Shift the lookahead token.  */
	    yy_symbol_print ("Shifting", yytoken,
			     yylval, yylloc);

            /* Discard the token being shifted.  */
            yychar = yyempty_;

            /* Count tokens shifted since error; after three, turn off error
               status.  */
            if (yyerrstatus_ > 0)
              --yyerrstatus_;

            yystate = yyn;
            yystack.push (yystate, yylval, yylloc);
            label = YYNEWSTATE;
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction (yyn, yystack, yylen);
	yystate = yystack.stateAt (0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs_;
            if (yychar == yyempty_)
              yytoken = yyempty_;
            yyerror (yylloc, yysyntax_error (yystate, yytoken));
          }

        yyerrloc = yylloc;
        if (yyerrstatus_ == 3)
          {
	    /* If just tried and failed to reuse lookahead token after an
	     error, discard it.  */

	    if (yychar <= EOF)
	      {
	      /* Return failure if at end of input.  */
	      if (yychar == EOF)
	        return false;
	      }
	    else
	      yychar = yyempty_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*---------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `---------------------------------------------------*/
      case YYERROR:

        yyerrloc = yystack.locationAt (yylen - 1);
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt (0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;	/* Each real token shifted decrements this.  */

        for (;;)
          {
	    yyn = yypact_[yystate];
	    if (!yy_pact_value_is_default_ (yyn))
	      {
	        yyn += yyterror_;
	        if (0 <= yyn && yyn <= yylast_ && yycheck_[yyn] == yyterror_)
	          {
	            yyn = yytable_[yyn];
	            if (0 < yyn)
		      break;
	          }
	      }

	    /* Pop the current state because it cannot handle the error token.  */
	    if (yystack.height == 0)
	      return false;

	    yyerrloc = yystack.locationAt (0);
	    yystack.pop ();
	    yystate = yystack.stateAt (0);
	    if (yydebug > 0)
	      yystack.print (yyDebugStream);
          }

	
	/* Muck with the stack to setup for yylloc.  */
	yystack.push (0, null, yylloc);
	yystack.push (0, null, yyerrloc);
        yyloc = yylloc (yystack, 2);
	yystack.pop (2);

        /* Shift the error token.  */
        yy_symbol_print ("Shifting", yystos_[yyn],
			 yylval, yyloc);

        yystate = yyn;
	yystack.push (yyn, yylval, yyloc);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
  }

  // Generate an error message.
  private String yysyntax_error (int yystate, int tok)
  {
    if (errorVerbose)
      {
        /* There are many possibilities here to consider:
           - Assume YYFAIL is not used.  It's too flawed to consider.
             See
             <http://lists.gnu.org/archive/html/bison-patches/2009-12/msg00024.html>
             for details.  YYERROR is fine as it does not invoke this
             function.
           - If this state is a consistent state with a default action,
             then the only way this function was invoked is if the
             default action is an error action.  In that case, don't
             check for expected tokens because there are none.
           - The only way there can be no lookahead present (in tok) is
             if this state is a consistent state with a default action.
             Thus, detecting the absence of a lookahead is sufficient to
             determine that there is no unexpected or expected token to
             report.  In that case, just report a simple "syntax error".
           - Don't assume there isn't a lookahead just because this
             state is a consistent state with a default action.  There
             might have been a previous inconsistent state, consistent
             state with a non-default action, or user semantic action
             that manipulated yychar.  (However, yychar is currently out
             of scope during semantic actions.)
           - Of course, the expected token list depends on states to
             have correct lookahead information, and it depends on the
             parser not to perform extra reductions after fetching a
             lookahead from the scanner and before detecting a syntax
             error.  Thus, state merging (from LALR or IELR) and default
             reductions corrupt the expected token list.  However, the
             list is correct for canonical LR with one exception: it
             will still contain any token that will not be accepted due
             to an error action in a later state.
        */
        if (tok != yyempty_)
          {
            // FIXME: This method of building the message is not compatible
            // with internationalization.
            StringBuffer res =
              new StringBuffer ("syntax error, unexpected ");
            res.append (yytnamerr_ (yytname_[tok]));
            int yyn = yypact_[yystate];
            if (!yy_pact_value_is_default_ (yyn))
              {
                /* Start YYX at -YYN if negative to avoid negative
                   indexes in YYCHECK.  In other words, skip the first
                   -YYN actions for this state because they are default
                   actions.  */
                int yyxbegin = yyn < 0 ? -yyn : 0;
                /* Stay within bounds of both yycheck and yytname.  */
                int yychecklim = yylast_ - yyn + 1;
                int yyxend = yychecklim < yyntokens_ ? yychecklim : yyntokens_;
                int count = 0;
                for (int x = yyxbegin; x < yyxend; ++x)
                  if (yycheck_[x + yyn] == x && x != yyterror_
                      && !yy_table_value_is_error_ (yytable_[x + yyn]))
                    ++count;
                if (count < 5)
                  {
                    count = 0;
                    for (int x = yyxbegin; x < yyxend; ++x)
                      if (yycheck_[x + yyn] == x && x != yyterror_
                          && !yy_table_value_is_error_ (yytable_[x + yyn]))
                        {
                          res.append (count++ == 0 ? ", expecting " : " or ");
                          res.append (yytnamerr_ (yytname_[x]));
                        }
                  }
              }
            return res.toString ();
          }
      }

    return "syntax error";
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yy_pact_value_is_default_ (int yyvalue)
  {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code> value indicates a syntax error.
   * @param yyvalue   the value to check
   */
  private static boolean yy_table_value_is_error_ (int yyvalue)
  {
    return yyvalue == yytable_ninf_;
  }

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
     STATE-NUM.  */
  private static final short yypact_ninf_ = -149;
  private static final short yypact_[] =
  {
        -9,     3,    36,   -21,  -149,    -4,    27,  -149,    -9,     1,
    -149,    95,  -149,  -149,  -149,  -149,    22,   125,   126,    94,
       1,    32,  -149,  -149,    -7,  -149,  -149,  -149,  -149,  -149,
    -149,  -149,     1,    19,   129,     1,    19,   135,     1,  -149,
    -149,  -149,   -29,    10,  -149,  -149,  -149,  -149,   138,  -149,
      39,  -149,  -149,  -149,  -149,  -149,   222,    19,  -149,  -149,
     222,  -149,    63,    35,    47,   222,   222,    19,   222,   222,
       6,  -149,    50,    76,    71,  -149,  -149,  -149,  -149,  -149,
      79,  -149,  -149,  -149,  -149,  -149,    75,  -149,    38,    92,
     119,   129,  -149,   101,   105,   128,    94,     1,   108,   122,
     136,  -149,  -149,     2,  -149,   265,   158,   404,   151,   222,
     222,   404,   283,  -149,   148,   148,   222,   152,   177,  -149,
      60,   149,   222,   222,   102,   222,   222,   222,   222,   222,
     222,   222,   222,   222,   222,   222,   222,     1,    -2,   129,
      19,  -149,  -149,   135,    29,    19,  -149,  -149,   188,   186,
      10,   222,   140,    19,  -149,     1,  -149,   143,   313,   330,
    -149,   360,   161,   222,   159,  -149,  -149,   345,   345,  -149,
    -149,   165,   133,   133,   148,   148,   148,   197,   197,   197,
     197,   197,   197,   404,  -149,    19,     1,  -149,   185,  -149,
      19,     1,   187,  -149,  -149,  -149,   404,   222,   154,   175,
      19,  -149,  -149,  -149,  -149,   222,  -149,   169,     1,   222,
     191,   204,  -149,   194,   207,  -149,   404,    19,   222,  -149,
     212,   168,    19,   215,  -149,  -149,  -149,   196,  -149,    19,
    -149,    19,   217,   390,  -149,    19,  -149,  -149,  -149,  -149,
     220,   228,  -149,    19,   229,  -149,  -149,  -149,  -149
  };

  /* YYDEFACT[S] -- default reduction number in state S.  Performed when
     YYTABLE doesn't specify something else to do.  Zero means the
     default is an error.  */
  private static final short yydefact_[] =
  {
         0,     0,     0,     2,     6,    18,     0,     1,     0,     0,
      19,     0,     5,     7,     8,    17,    15,     0,     0,     0,
       0,     0,    28,    25,     0,    21,    29,    38,    22,    48,
      23,    24,     0,     0,     0,     0,     0,     0,     0,    10,
       9,    13,     0,    55,    30,    39,    49,    20,    27,    16,
      92,    89,    90,    87,    88,   100,     0,     0,    96,    68,
      79,    91,     0,    94,     0,   128,     0,     0,     0,     0,
     107,    60,     0,     0,    56,    61,    62,    63,    64,    65,
      86,    93,    97,    98,    66,    67,    10,    32,     0,     0,
       0,     0,    40,    42,     0,     0,     0,     0,     0,     0,
      52,    54,    26,     0,    92,     0,     0,    80,     0,     0,
       0,   129,     0,    57,   124,   126,     0,   108,     0,    34,
       3,    58,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,    44,    41,     0,     0,     0,    14,    31,     0,     0,
       0,     0,    11,     0,   127,     0,    82,     0,     0,     0,
     125,   103,     0,     0,    10,    59,     4,   111,   112,   101,
     102,   105,   113,   114,   115,   116,   117,   118,   119,   120,
     121,   122,   123,    69,    11,     0,     0,    33,     0,    43,
       0,     0,     0,    50,    51,    53,    70,     0,     0,     0,
       0,    84,    83,    95,    99,     0,   110,     0,     0,     0,
       0,     0,    36,     0,     0,    46,    71,     0,     0,    75,
      73,     0,     0,     0,   104,   109,    12,     0,    35,     0,
      45,     0,     0,     0,    74,     0,    76,    81,    85,   106,
       0,     0,    77,     0,     0,    37,    47,    72,    78
  };

  /* YYPGOTO[NTERM-NUM].  */
  private static final short yypgoto_[] =
  {
      -149,  -149,  -149,  -149,   -18,   -93,   -33,   230,  -149,  -149,
    -149,   239,   200,  -149,  -149,   231,  -149,   232,  -149,  -149,
     112,   236,  -149,  -149,   109,  -149,   -36,  -149,  -149,  -149,
      40,  -149,  -149,   104,  -149,  -149,  -149,    87,  -149,  -148,
    -149,  -149,  -149,  -149,  -149
  };

  /* YYDEFGOTO[NTERM-NUM].  */
  private static final short
  yydefgoto_[] =
  {
        -1,     2,   121,     3,    15,    41,    71,    72,    10,    16,
       6,     4,    23,    24,    25,    26,    88,    27,    28,    93,
      94,    29,    30,   100,   101,    31,    73,    74,    75,   220,
     221,    76,    77,   156,   157,    78,    79,    80,   171,   162,
      81,    82,    83,    84,    85
  };

  /* YYTABLE[YYPACT[STATE-NUM]].  What to do in state STATE-NUM.  If
     positive, shift that token.  If negative, reduce the rule which
     number is the opposite.  If YYTABLE_NINF_, syntax error.  */
  private static final short yytable_ninf_ = -11;
  private static final short
  yytable_[] =
  {
        90,    87,    43,   146,    92,     1,    13,    13,     5,    96,
      47,    13,    97,    98,    49,   207,    99,    89,   185,     8,
      95,   106,    50,    51,    40,   146,    52,    53,    54,    14,
      14,   113,    55,    48,    14,    17,     7,    56,    18,   186,
      57,    58,   116,     9,    19,    59,    60,    11,    61,   190,
      62,    63,   117,    64,    65,    66,   151,   224,   142,    67,
      32,   227,    68,    50,    51,    40,   108,    52,    53,    54,
     191,   109,    69,    55,    70,   138,   139,   -10,    56,   147,
     103,    57,    58,   110,   165,   152,    59,    60,   118,    61,
     122,    62,    63,   119,    64,    65,    66,    39,    17,    40,
     -11,    18,   123,    68,   188,   169,   187,    19,   170,   192,
      92,   120,   140,    69,    20,    70,   137,   198,   124,   184,
      21,   125,   126,   127,   128,   129,   130,   131,   132,   133,
     134,   135,    86,   136,    40,    22,   141,   199,    86,   143,
      40,    17,   144,   105,    18,    33,    36,   107,   145,   210,
      19,   148,   111,   112,   213,   114,   115,    20,   200,    91,
     201,    34,    37,    21,   223,   149,    35,    38,   211,   217,
     218,   219,   124,   214,   150,   154,   155,   127,   128,   129,
     164,   232,    40,   235,   155,   236,   237,   124,   163,   166,
     226,   193,   194,   240,   197,   241,   158,   159,   206,   244,
     208,   209,   212,   161,   215,   222,   225,   247,   228,   167,
     168,   230,   172,   173,   174,   175,   176,   177,   178,   179,
     180,   181,   182,   183,   229,   104,    51,   231,   218,    52,
      53,    54,   238,   239,   242,    55,   124,   245,   196,   125,
     126,   127,   128,   129,    58,   246,   248,    12,   102,    42,
     161,    61,    44,    45,    63,   189,    64,    46,    66,   195,
     234,   202,     0,     0,     0,    68,     0,     0,     0,     0,
       0,     0,     0,     0,     0,    69,   122,    70,     0,     0,
       0,     0,     0,     0,   216,     0,     0,     0,   123,     0,
       0,     0,   161,     0,   122,   153,   161,     0,     0,     0,
       0,     0,     0,     0,   124,   233,   123,   125,   126,   127,
     128,   129,   130,   131,   132,   133,   134,   135,     0,     0,
     160,     0,   124,     0,   122,   125,   126,   127,   128,   129,
     130,   131,   132,   133,   134,   135,   123,     0,     0,     0,
       0,   122,     0,     0,     0,     0,     0,     0,     0,     0,
     203,     0,   124,   123,     0,   125,   126,   127,   128,   129,
     130,   131,   132,   133,   134,   135,     0,   204,     0,   124,
       0,   122,   125,   126,   127,   128,   129,   130,   131,   132,
     133,   134,   135,   123,   124,     0,     0,   125,   126,   127,
     128,   129,   130,   131,   132,   133,   134,   135,   205,   124,
       0,   122,   125,   126,   127,   128,   129,   130,   131,   132,
     133,   134,   135,   123,     0,   122,     0,     0,     0,     0,
     243,     0,     0,     0,     0,     0,     0,   123,     0,   124,
       0,     0,   125,   126,   127,   128,   129,   130,   131,   132,
     133,   134,   135,   124,     0,     0,   125,   126,   127,   128,
     129,   130,   131,   132,   133,   134,   135
  };

  /* YYCHECK.  */
  private static final short
  yycheck_[] =
  {
        36,    34,    20,    96,    37,    14,     5,     5,     5,    38,
      17,     5,    41,     3,    32,   163,     6,    35,    20,    40,
      38,    57,     3,     4,     5,   118,     7,     8,     9,    28,
      28,    67,    13,    40,    28,     3,     0,    18,     6,    41,
      21,    22,    36,    47,    12,    26,    27,    20,    29,    20,
      31,    32,    70,    34,    35,    36,    54,   205,    91,    40,
      38,   209,    43,     3,     4,     5,     3,     7,     8,     9,
      41,    36,    53,    13,    55,    37,    38,    38,    18,    97,
      41,    21,    22,    36,   120,   103,    26,    27,    38,    29,
      11,    31,    32,    17,    34,    35,    36,     3,     3,     5,
      40,     6,    23,    43,   140,     3,   139,    12,     6,   145,
     143,    40,    20,    53,    19,    55,    41,   153,    39,   137,
      25,    42,    43,    44,    45,    46,    47,    48,    49,    50,
      51,    52,     3,    54,     5,    40,    17,   155,     3,    38,
       5,     3,    37,    56,     6,    20,    20,    60,    20,   185,
      12,    43,    65,    66,   190,    68,    69,    19,    15,    24,
      17,    36,    36,    25,   200,    43,    41,    41,   186,    15,
      16,    17,    39,   191,    38,    17,    33,    44,    45,    46,
       3,   217,     5,    15,    33,    17,   222,    39,    36,    40,
     208,     3,     6,   229,    54,   231,   109,   110,    37,   235,
      41,    36,    17,   116,    17,    30,    37,   243,    17,   122,
     123,    17,   125,   126,   127,   128,   129,   130,   131,   132,
     133,   134,   135,   136,    20,     3,     4,    20,    16,     7,
       8,     9,    17,    37,    17,    13,    39,    17,   151,    42,
      43,    44,    45,    46,    22,    17,    17,     8,    48,    19,
     163,    29,    21,    21,    32,   143,    34,    21,    36,   150,
     220,   157,    -1,    -1,    -1,    43,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    53,    11,    55,    -1,    -1,
      -1,    -1,    -1,    -1,   197,    -1,    -1,    -1,    23,    -1,
      -1,    -1,   205,    -1,    11,    30,   209,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    39,   218,    23,    42,    43,    44,
      45,    46,    47,    48,    49,    50,    51,    52,    -1,    -1,
      37,    -1,    39,    -1,    11,    42,    43,    44,    45,    46,
      47,    48,    49,    50,    51,    52,    23,    -1,    -1,    -1,
      -1,    11,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      37,    -1,    39,    23,    -1,    42,    43,    44,    45,    46,
      47,    48,    49,    50,    51,    52,    -1,    37,    -1,    39,
      -1,    11,    42,    43,    44,    45,    46,    47,    48,    49,
      50,    51,    52,    23,    39,    -1,    -1,    42,    43,    44,
      45,    46,    47,    48,    49,    50,    51,    52,    38,    39,
      -1,    11,    42,    43,    44,    45,    46,    47,    48,    49,
      50,    51,    52,    23,    -1,    11,    -1,    -1,    -1,    -1,
      30,    -1,    -1,    -1,    -1,    -1,    -1,    23,    -1,    39,
      -1,    -1,    42,    43,    44,    45,    46,    47,    48,    49,
      50,    51,    52,    39,    -1,    -1,    42,    43,    44,    45,
      46,    47,    48,    49,    50,    51,    52
  };

  /* STOS_[STATE-NUM] -- The (internal number of the) accessing
     symbol of state STATE-NUM.  */
  private static final byte
  yystos_[] =
  {
         0,    14,    58,    60,    68,     5,    67,     0,    40,    47,
      65,    20,    68,     5,    28,    61,    66,     3,     6,    12,
      19,    25,    40,    69,    70,    71,    72,    74,    75,    78,
      79,    82,    38,    20,    36,    41,    20,    36,    41,     3,
       5,    62,    64,    61,    72,    74,    78,    17,    40,    61,
       3,     4,     7,     8,     9,    13,    18,    21,    22,    26,
      27,    29,    31,    32,    34,    35,    36,    40,    43,    53,
      55,    63,    64,    83,    84,    85,    88,    89,    92,    93,
      94,    97,    98,    99,   100,   101,     3,    63,    73,    61,
      83,    24,    63,    76,    77,    61,    38,    41,     3,     6,
      80,    81,    69,    41,     3,    94,    83,    94,     3,    36,
      36,    94,    94,    83,    94,    94,    36,    61,    38,    17,
      40,    59,    11,    23,    39,    42,    43,    44,    45,    46,
      47,    48,    49,    50,    51,    52,    54,    41,    37,    38,
      20,    17,    63,    38,    37,    20,    62,    61,    43,    43,
      38,    54,    61,    30,    17,    33,    90,    91,    94,    94,
      37,    94,    96,    36,     3,    83,    40,    94,    94,     3,
       6,    95,    94,    94,    94,    94,    94,    94,    94,    94,
      94,    94,    94,    94,    61,    20,    41,    63,    83,    77,
      20,    41,    83,     3,     6,    81,    94,    54,    83,    61,
      15,    17,    90,    37,    37,    38,    37,    96,    41,    36,
      83,    61,    17,    83,    61,    17,    94,    15,    16,    17,
      86,    87,    30,    83,    96,    37,    61,    96,    17,    20,
      17,    20,    83,    94,    87,    15,    17,    83,    17,    37,
      83,    83,    17,    30,    83,    17,    17,    83,    17
  };

  /* TOKEN_NUMBER_[YYLEX-NUM] -- Internal symbol number corresponding
     to YYLEX-NUM.  */
  private static final short
  yytoken_number_[] =
  {
         0,   256,   257,   258,   259,   260,   261,   262,   263,   264,
     265,   266,   267,   268,   269,   270,   271,   272,   273,   274,
     275,   276,   277,   278,   279,   280,   281,   282,   283,   284,
     285,   286,   287,   288,   289,   290,   291,   292,   293,   294,
     295,   296,   297,   298,   299,   300,   301,   302,   303,   304,
     305,   306,   307,   308,   309,   310,   311
  };

  /* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final byte
  yyr1_[] =
  {
         0,    57,    58,    59,    59,    60,    60,    61,    61,    62,
      62,    63,    63,    64,    64,    65,    66,    66,    67,    67,
      68,    69,    69,    69,    69,    70,    70,    70,    70,    71,
      71,    72,    73,    73,    74,    74,    74,    74,    75,    75,
      76,    76,    77,    77,    78,    78,    78,    78,    79,    79,
      80,    80,    81,    81,    82,    82,    83,    83,    83,    83,
      84,    84,    84,    84,    84,    84,    84,    84,    84,    85,
      85,    85,    86,    87,    87,    88,    88,    88,    88,    89,
      89,    90,    91,    91,    92,    92,    93,    94,    94,    94,
      94,    94,    94,    94,    94,    94,    94,    94,    94,    94,
      94,    95,    95,    96,    96,    97,    97,    98,    98,    98,
      98,    99,    99,    99,    99,    99,    99,    99,    99,    99,
      99,    99,    99,    99,    99,    99,    99,   100,   101,   101
  };

  /* YYR2[YYN] -- Number of symbols composing right hand side of rule YYN.  */
  private static final byte
  yyr2_[] =
  {
         0,     2,     1,     1,     2,     3,     1,     1,     1,     1,
       1,     3,     5,     1,     3,     2,     3,     1,     1,     2,
       5,     1,     1,     1,     1,     1,     3,     2,     1,     1,
       2,     4,     1,     3,     4,     7,     6,     9,     1,     2,
       1,     2,     1,     3,     4,     7,     6,     9,     1,     2,
       3,     3,     1,     3,     3,     2,     1,     2,     2,     3,
       1,     1,     1,     1,     1,     1,     1,     1,     1,     3,
       4,     5,     4,     1,     2,     5,     6,     7,     8,     1,
       2,     4,     1,     2,     4,     6,     1,     1,     1,     1,
       1,     1,     1,     1,     1,     4,     1,     1,     1,     4,
       1,     1,     1,     1,     3,     3,     6,     1,     2,     5,
       4,     3,     3,     3,     3,     3,     3,     3,     3,     3,
       3,     3,     3,     3,     2,     3,     2,     3,     1,     2
  };

  /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
     First, the terminals, then, starting at \a yyntokens_, nonterminals.  */
  private static final String yytname_[] =
  {
    "$end", "error", "$undefined", "ID", "STRING", "UPCASE_ID", "ITER_NAME",
  "INT", "BOOL", "CHAR", "ERROR", "AND", "ATTR", "BREAK", "CLASS", "ELSE",
  "ELSIF", "END", "IF", "INCLUDE", "IS", "LOOP", "NEW", "OR", "ONCE",
  "PRIVATE", "QUIT", "RETURN", "SAME", "SELF", "THEN", "TYPECASE", "VOID",
  "WHEN", "WHILE", "YIELD", "\"(\"", "\")\"", "\",\"", "\".\"", "\";\"",
  "\":\"", "\"+\"", "\"-\"", "\"*\"", "\"/\"", "\"%\"", "\"<\"", "\"<=\"",
  "\"=\"", "\"/=\"", "\">\"", "\">=\"", "\"~\"", "\":=\"", "\"#\"",
  "UMINUS", "$accept", "source", "semicolon_list", "class_list",
  "type_specifier", "name", "routine_argument", "identifier_list",
  "subtyping_clause", "type_spec_list", "class_def", "class",
  "class_element", "class_element_list", "attr_definition",
  "public_attr_definition", "routine_arg_list", "routine_def_public",
  "routine_definition", "iter_argument", "iter_arg_list",
  "iter_definition_public", "iter_definition", "feature_modifier",
  "feature_modifier_list", "include_clause", "statement_list", "statement",
  "assign_statement", "elseif_expre", "elseif_list", "if_statement",
  "return_statement", "when_expr", "when_list", "typecase_statement",
  "expression_statement", "expression", "call_name", "expression_list",
  "call_expression", "create_expression", "sugar_expression",
  "loop_statement", "yield_statement", null
  };

  /* YYRHS -- A `-1'-separated list of the rules' RHS.  */
  private static final byte yyrhs_[] =
  {
        58,     0,    -1,    60,    -1,    40,    -1,    59,    40,    -1,
      60,    40,    68,    -1,    68,    -1,     5,    -1,    28,    -1,
       5,    -1,     3,    -1,     3,    41,    61,    -1,    64,    38,
       3,    41,    61,    -1,    62,    -1,    64,    38,    62,    -1,
      47,    66,    -1,    66,    38,    61,    -1,    61,    -1,     5,
      -1,     5,    65,    -1,    14,    67,    20,    70,    17,    -1,
      71,    -1,    75,    -1,    79,    -1,    82,    -1,    69,    -1,
      70,    40,    69,    -1,    70,    40,    -1,    40,    -1,    72,
      -1,    25,    72,    -1,    12,    64,    41,    61,    -1,    63,
      -1,    73,    38,    63,    -1,     3,    20,    83,    17,    -1,
       3,    36,    73,    37,    20,    83,    17,    -1,     3,    41,
      61,    20,    83,    17,    -1,     3,    36,    73,    37,    41,
      61,    20,    83,    17,    -1,    74,    -1,    25,    74,    -1,
      63,    -1,    24,    63,    -1,    76,    -1,    76,    38,    77,
      -1,     6,    20,    83,    17,    -1,     6,    36,    77,    37,
      20,    83,    17,    -1,     6,    41,    61,    20,    83,    17,
      -1,     6,    36,    77,    37,    41,    61,    20,    83,    17,
      -1,    78,    -1,    25,    78,    -1,     3,    43,     3,    -1,
       6,    43,     6,    -1,    80,    -1,    80,    38,    81,    -1,
      19,    61,    81,    -1,    19,    61,    -1,    84,    -1,    40,
      83,    -1,    84,    59,    -1,    84,    40,    83,    -1,    63,
      -1,    85,    -1,    88,    -1,    89,    -1,    92,    -1,    93,
      -1,   100,    -1,   101,    -1,    26,    -1,    94,    54,    94,
      -1,     3,    41,    54,    94,    -1,     3,    41,    61,    54,
      94,    -1,    16,    94,    30,    83,    -1,    86,    -1,    86,
      87,    -1,    18,    94,    30,    83,    17,    -1,    18,    94,
      30,    83,    87,    17,    -1,    18,    94,    30,    83,    15,
      83,    17,    -1,    18,    94,    30,    83,    87,    15,    83,
      17,    -1,    27,    -1,    27,    94,    -1,    33,    61,    30,
      83,    -1,    90,    -1,    91,    90,    -1,    31,     3,    91,
      17,    -1,    31,     3,    91,    15,    83,    17,    -1,    94,
      -1,     8,    -1,     9,    -1,     4,    -1,     7,    -1,    29,
      -1,     3,    -1,    97,    -1,    32,    -1,    32,    36,    94,
      37,    -1,    22,    -1,    98,    -1,    99,    -1,    34,    36,
      94,    37,    -1,    13,    -1,     3,    -1,     6,    -1,    94,
      -1,    94,    38,    96,    -1,    94,    39,    95,    -1,    94,
      39,    95,    36,    96,    37,    -1,    55,    -1,    55,    61,
      -1,    55,    61,    36,    96,    37,    -1,    55,    36,    96,
      37,    -1,    94,    11,    94,    -1,    94,    23,    94,    -1,
      94,    42,    94,    -1,    94,    43,    94,    -1,    94,    44,
      94,    -1,    94,    45,    94,    -1,    94,    46,    94,    -1,
      94,    47,    94,    -1,    94,    48,    94,    -1,    94,    49,
      94,    -1,    94,    50,    94,    -1,    94,    51,    94,    -1,
      94,    52,    94,    -1,    43,    94,    -1,    36,    94,    37,
      -1,    53,    94,    -1,    21,    83,    17,    -1,    35,    -1,
      35,    94,    -1
  };

  /* YYPRHS[YYN] -- Index of the first RHS symbol of rule number YYN in
     YYRHS.  */
  private static final short yyprhs_[] =
  {
         0,     0,     3,     5,     7,    10,    14,    16,    18,    20,
      22,    24,    28,    34,    36,    40,    43,    47,    49,    51,
      54,    60,    62,    64,    66,    68,    70,    74,    77,    79,
      81,    84,    89,    91,    95,   100,   108,   115,   125,   127,
     130,   132,   135,   137,   141,   146,   154,   161,   171,   173,
     176,   180,   184,   186,   190,   194,   197,   199,   202,   205,
     209,   211,   213,   215,   217,   219,   221,   223,   225,   227,
     231,   236,   242,   247,   249,   252,   258,   265,   273,   282,
     284,   287,   292,   294,   297,   302,   309,   311,   313,   315,
     317,   319,   321,   323,   325,   327,   332,   334,   336,   338,
     343,   345,   347,   349,   351,   355,   359,   366,   368,   371,
     377,   382,   386,   390,   394,   398,   402,   406,   410,   414,
     418,   422,   426,   430,   434,   437,   441,   444,   448,   450
  };

  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
  private static final short yyrline_[] =
  {
         0,    99,    99,   106,   110,   114,   119,   124,   128,   132,
     136,   140,   145,   162,   170,   175,   179,   187,   194,   199,
     206,   211,   215,   219,   223,   227,   231,   235,   239,   244,
     248,   253,   267,   271,   276,   284,   295,   303,   313,   317,
     323,   327,   331,   335,   340,   348,   359,   367,   378,   382,
     386,   391,   396,   400,   405,   411,   417,   421,   425,   429,
     435,   439,   443,   447,   451,   455,   459,   463,   467,   472,
     479,   485,   491,   501,   505,   511,   522,   536,   550,   565,
     570,   576,   582,   586,   591,   597,   606,   610,   615,   620,
     625,   630,   635,   640,   644,   649,   655,   660,   664,   668,
     674,   679,   683,   687,   691,   696,   704,   716,   721,   726,
     732,   748,   755,   763,   769,   775,   781,   787,   793,   799,
     805,   811,   817,   823,   830,   836,   840,   846,   852,   857
  };

  // Report on the debug stream that the rule yyrule is going to be reduced.
  private void yy_reduce_print (int yyrule, YYStack yystack)
  {
    if (yydebug == 0)
      return;

    int yylno = yyrline_[yyrule];
    int yynrhs = yyr2_[yyrule];
    /* Print the symbols being reduced, and their result.  */
    yycdebug ("Reducing stack by rule " + (yyrule - 1)
	      + " (line " + yylno + "), ");

    /* The symbols being reduced.  */
    for (int yyi = 0; yyi < yynrhs; yyi++)
      yy_symbol_print ("   $" + (yyi + 1) + " =",
		       yyrhs_[yyprhs_[yyrule] + yyi],
		       ((yystack.valueAt (yynrhs-(yyi + 1)))),
		       yystack.locationAt (yynrhs-(yyi + 1)));
  }

  /* YYTRANSLATE(YYLEX) -- Bison symbol number corresponding to YYLEX.  */
  private static final byte yytranslate_table_[] =
  {
         0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    43,    44,
      45,    46,    47,    48,    49,    50,    51,    52,    53,    54,
      55,    56
  };

  private static final byte yytranslate_ (int t)
  {
    if (t >= 0 && t <= yyuser_token_number_max_)
      return yytranslate_table_[t];
    else
      return yyundef_token_;
  }

  private static final int yylast_ = 456;
  private static final int yynnts_ = 45;
  private static final int yyempty_ = -2;
  private static final int yyfinal_ = 7;
  private static final int yyterror_ = 1;
  private static final int yyerrcode_ = 256;
  private static final int yyntokens_ = 57;

  private static final int yyuser_token_number_max_ = 311;
  private static final int yyundef_token_ = 2;

/* User implementation code.  */
/* Unqualified %code blocks.  */
/* Line 922 of lalr1.java  */
/* Line 8 of "parser.y"  */

     private ASTree ast;
     public ASTree getAST()
     {
	  return ast;
     }


/* Line 922 of lalr1.java  */
/* Line 2888 of "Parser.java"  */

}

/* Line 926 of lalr1.java  */
/* Line 863 of "parser.y"  */


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

