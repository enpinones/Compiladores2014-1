all: Scanner.java Parser.java Main.java
	javac $^

Scanner.java: lp.l Parser.java
	jflex $<

Parser.java: lp.y
	bison $^

clean:
	$(RM) *.class
	$(RM) Scanner.java
	$(RM) Scanner.java~
	$(RM) Parser.java
