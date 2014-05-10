all: Scanner.java Parser.java Main.java Symbol.java
	javac $^

Scanner.java: lexer.l Parser.java
	jflex $<

Parser.java: parser.y
	bison $^

clean:
	$(RM) *.class
	$(RM) Scanner.java
	$(RM) Scanner.java~
	$(RM) Parser.java
