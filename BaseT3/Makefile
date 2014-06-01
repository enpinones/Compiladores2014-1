BINDIR = ./bin

all: 
	cd analysis && make all;
	javac -Xlint:unchecked -g -d $(BINDIR) *.java

clean:
	cd analysis && make clean;
	$(RM) $(BINDIR)/*.class
