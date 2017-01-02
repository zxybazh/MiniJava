import java.util.*;

public class EvalVisitor extends MiniJavaBaseVisitor<Integer> {
    /** "memory" for our MiniJavaulator; variable/value pairs go here */
    Set<String> Existance;
    Map<String, Integer> Inheritance;
    int VisitCount = 0;
    /** Goal */
    @Override
    public Integer visitGoal(MiniJavaParser.GoalContext ctx) {
        VisitCount += 1;
        System.out.println("This is the "+this.VisitCount+" visit to the AST.");
        return visitChildren(ctx);
    }

    /** MainClass */
    @Override
    public Integer visitMainClass(MiniJavaParser.MainClassContext ctx) {
        return visitChildren(ctx);
    }

    /** ClassDeclaration */
    @Override
    public Integer visitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        return visitChildren(ctx);
    }

    /** MethodDeclaration */
    @Override
    public Integer visitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
        return visitChildren(ctx);
    }

    /** Type */
    @Override
    public Integer visitType(MiniJavaParser.TypeContext ctx) {
        return visitChildren(ctx);
    }

    /** Statement */
    @Override
    public Integer visitStatement(MiniJavaParser.StatementContext ctx) {
        return visitChildren(ctx);
    }

    /** Expression */
    @Override
    public Integer visitExpression(MiniJavaParser.ExpressionContext ctx) {
        return visitChildren(ctx);
    }

    /** Parameter */
    @Override
    public Integer visitParameter(MiniJavaParser.ParameterContext ctx) {
        return visitChildren(ctx);
    }

    /** VarDeclaration */
    @Override
    public Integer visitVarDeclaration(MiniJavaParser.VarDeclarationContext ctx) {
        return visitChildren(ctx);
    }

    /** ParameterList */
    @Override
    public Integer visitParameterList(MiniJavaParser.ParameterListContext ctx) {
        return visitChildren(ctx);
    }
}
