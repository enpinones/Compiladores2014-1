all: Scanner.java Main.java
	javac $^

Scanner.java: lexer.l
	jflex $^

clean:
	$(RM) *.class
	$(RM) Scanner.java
	$(RM) Scanner.java~
