all: Scanner.java Parser.java Main.java
	javac $^

Scanner.java: lexer.l Parser.java
	jflex $<

Parser.java: parser.y
	bison $^

clean:
	$(RM) *.class
	$(RM) Scanner.java
	$(RM) Parser.java
