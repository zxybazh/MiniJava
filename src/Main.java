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

        eval.visit(tree);
        eval.visit(tree);
        //eval.visit(tree);

        //System.out.println(eval.Existance);
        //System.out.println(eval.Inheritance);
        //System.out.println(eval.Function);
        //System.out.println(eval.Definition);
        //System.out.println(eval.Invoke);
        //System.out.println(eval.ParameterNum);
        //System.out.println(eval.Parameters);

        if (eval.FinalMessage.equals("")) eval.FinalMessage = "Method Invoke Check Passed : )";
        System.out.println(eval.FinalMessage);

        //System.out.println("\n\n"+"Here is the Parsing Tree:\n======================\n"
        //    +tree.toStringTree(parser));
    }
}
