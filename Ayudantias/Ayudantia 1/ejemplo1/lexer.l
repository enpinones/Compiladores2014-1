// -*- mode: java -*-

import java.io.*;

%%

%unicode
%class Scanner
%int

%{
    private int lowercase;
    private int uppercase;
    private int other;

    public int print_data() {

	System.out.printf("%d %d %d\n", lowercase, uppercase, other);
	return 0;
    }
%}


%init{
    this.lowercase = 0;
    this.uppercase = 0;
    this.other = 0;
%init}

%%

[a-z][a-zA-Z]* {
    this.lowercase ++;
}

[A-Z][a-zA-Z]* {
    this.uppercase ++;
}

[ \n\r\t]+ {
    /* void */
}

[^a-zA-Z]+ {
    this.other ++;
}

<<EOF>> {
    return print_data();
}

