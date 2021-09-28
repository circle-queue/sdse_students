all: clean compile run

clean:
	rm -f classes/org/nypl/journalsystem/*.class

compile:
	javac src/org/nypl/journalsystem/LibrarySystem.java -cp ./classes/ -d ./classes/ -s ./src/

run:
	java -cp ./classes/ org/nypl/journalsystem/LibrarySystem
