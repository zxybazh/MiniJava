build: MiniJava.g4
	@rm -rf ../output
	@mkdir ../output
	@java -Xmx500M -cp "/usr/local/lib/antlr-4.5.3-complete.jar:$CLASSPATH" org.antlr.v4.Tool MiniJava.g4
	@echo Compiled Antlr Grammer
	@javac MiniJava*.java
	@echo Compiled All Classes
clean:
	@rm *.class
	@rm MiniJava*.java
	@rm MiniJava*.tokens
	@echo Cleaned
	@rm -rf ../output
	@mkdir ../output
test:
	@java org.antlr.v4.gui.TestRig MiniJava goal -tree < ../sample/factorial.java > ../output/factorial.lisp
	@echo Completed Test Factorial.
	@java org.antlr.v4.gui.TestRig MiniJava goal -tree < ../sample/binarysearch.java > ../output/binarysearch.lisp
	@echo Completed Test Binarysearch.
	@java org.antlr.v4.gui.TestRig MiniJava goal -tree < ../sample/binarytree.java > ../output/binarytree.lisp
	@echo Completed Test Binarytree.
	@java org.antlr.v4.gui.TestRig MiniJava goal -tree < ../sample/bubblesort.java > ../output/bubblesort.lisp
	@echo Completed Test Bubblesort.
	@java org.antlr.v4.gui.TestRig MiniJava goal -tree < ../sample/linearsearch.java > ../output/linearsearch.lisp
	@echo Completed Test Linearsearch.
	@java org.antlr.v4.gui.TestRig MiniJava goal -tree < ../sample/linkedlist.java > ../output/linkedlist.lisp
	@echo Completed Test Linkedlist.
	@java org.antlr.v4.gui.TestRig MiniJava goal -tree < ../sample/quicksort.java > ../output/quicksort.lisp
	@echo Completed Test Quicksort.
	@java org.antlr.v4.gui.TestRig MiniJava goal -tree < ../sample/treevisitor.java > ../output/treevisitor.lisp
	@echo Completed Test Treevisitor.
gui:
	java org.antlr.v4.gui.TestRig MiniJava goal -gui < ../sample/factorial.java
