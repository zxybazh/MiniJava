import java.io.*;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {

    public static void main(String[] args) throws Exception {
        InputStream is = args.length > 0 ? new FileInputStream(args[0]) : System.in;

        ANTLRInputStream input = new ANTLRInputStream(is);
        MiniJavaLexer lexer = new MiniJavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniJavaParser parser = new MiniJavaParser(tokens);
        ParseTree tree = parser.goal();

        EvalVisitor eval = new EvalVisitor();

        /** 1st Vist, to check existance of type*/
        eval.visit(tree);
        /** 2nd Vist, to check inheritance of type*/
        eval.visit(tree);
        /** 3rd Vist, to check type match when given as arguments*/
        eval.visit(tree);

        System.out.println("\n\n"+"Here is the Parsing Tree:\n==================\n"
            +tree.toStringTree(parser));
    }
}
