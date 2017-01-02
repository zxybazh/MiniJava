# MiniJava
The repository for Compiler project of a MiniJava Parser Front upon ANTLR 4

##Prerequisites 

**Java Runtime**(1.6 or higher)

[**ANTLR4**](https://github.com/antlr/antlr4) : (ANother Tool for Language Recognition) is a powerful parser generator for reading, processing, executing, or translating structured text or binary files. It's widely used to build languages, tools, and frameworks. From a grammar, ANTLR generates a parser that can build parse trees and also generates a listener interface (or visitor) that makes it easy to respond to the recognition of phrases of interest.

```
$ cd /usr/local/lib
$ curl -O http://www.antlr.org/download/antlr-4.5.3-complete.jar
```

##Getting Started with MiniJava

To simply build from my MiniJava Grammar File, you can use my make file.

```
$ cd src
$ make
$ make gui
```

If you want to clean the whole directory, simple run `make clean`.
If you want to generate results of all sample file, simple run `make test`.
To manually input the program you can try the following instruction, after you have run `make` and export `antlr4` jar file into your `\usr\local\lib`
```
$ cd src
$ java org.antlr.v4.gui.TestRig MiniJava goal -tree
$ java org.antlr.v4.gui.TestRig MiniJava goal -gui
```

##Helpful Links
[Getting Started with ANTLR v4](https://github.com/antlr/antlr4/blob/master/doc/getting-started.md)
[BNF for MiniJava](http://www.cambridge.org/us/features/052182060X/grammar.html)
