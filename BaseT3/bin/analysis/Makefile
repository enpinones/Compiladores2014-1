all: Scanner.java Parser.java

Scanner.java: lexer.l Parser.java
	jflex $<

Parser.java: parser.y
	bison --report all $^

clean:
	$(RM) *.class
	$(RM) Scanner.java
	$(RM) Parser.java
