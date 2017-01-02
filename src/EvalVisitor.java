import java.util.*;

public class EvalVisitor extends MiniJavaBaseVisitor<Integer> {
    /** "memory" for our MiniJavaulator; variable/value pairs go here */
    Map<String, String> Existance   = new HashMap<String, String>(); // Type    -   What
    Map<String, String> Inheritance = new HashMap<String, String>(); // Type    -   Type
    Map<String, String> Function    = new HashMap<String, String>(); // Method  -   Class
    Map<String, String> Definition  = new HashMap<String, String>(); // Var     -   Type
    Map<String, Integer> ParameterNum= new HashMap<String, Integer>();// Var     -   Number of Parameters
    Map<String, String> Parameters  = new HashMap<String, String>(); // Class+Method+No. - Type (to Check)

    String FinalMessage = "";
    String CurrentClass = "";
    String CurrentMethod = "";
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
        this.CurrentClass = ctx.getChild(1).getText();
        if (VisitCount == 1) {
            Existance.put(ctx.getChild(1).getText(), "Class");
        }
        return visitChildren(ctx);
    }

    /** ClassDeclaration */
    @Override
    public Integer visitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        this.CurrentClass = ctx.getChild(1).getText();
        if (VisitCount == 1) {
            Existance.put(ctx.getChild(1).getText(), "Class");
            if (ctx.getChild(2).equals("extends"))
                Inheritance.put(ctx.getChild(1).getText(), ctx.getChild(3).getText());
        }
        return visitChildren(ctx);
    }

    /** MethodDeclaration */
    @Override
    public Integer visitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
        this.CurrentMethod = ctx.getChild(2).getText();
        if (VisitCount == 1) {
            Existance.put(ctx.getChild(2).getText(), "Method");
            Function.put(ctx.getChild(2).getText(), CurrentClass);
        }
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
        if (VisitCount == 2 && ctx.getChildCount() > 2 && ctx.getChild(1).getText().equals(".")) {
            //System.out.println(ctx.getText()+"---");
            String CheckVar = ctx.getChild(0).getText();
            String CheckMethod = ctx.getChild(2).getText();
            //System.out.println(Existance);
            if (Definition.containsKey(CheckVar)) {
                //System.out.println(CheckVar);
                //System.out.println(CheckMethod);
                String CheckClass = Definition.get(CheckVar);
                if (Function.containsKey(CheckMethod)) {
                    String DesignatedClass = Function.get(CheckMethod);
                    while (!CheckClass.equals(DesignatedClass) && Inheritance.containsKey(CheckClass)) {
                        CheckClass = Inheritance.get(CheckClass);
                    }
                    if (!DesignatedClass.equals(CheckClass)) {
                        FinalMessage += "+--------------------+\n";
                        FinalMessage += "Error: Wrong Method Invoke @ "+ctx.getText()+" >_<!!!\n"+"Method:\t"+CheckMethod+"\nVar:\t"+CheckVar+"\n";
                        FinalMessage += "The method corresponds to this type: " + DesignatedClass+"\n";
                    }
                } else {
                    FinalMessage += "+--------------------+\n";
                    FinalMessage += "Error: There's no such method @ "+ctx.getText()+" >_<!!!\n"+"Method:\t"+CheckMethod+"\nVar:\t"+CheckVar+"\n";
                }
            }
        }
        //System.out.println(ctx.getSourceInterval());
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
        if (VisitCount == 1) {
            Definition.put(ctx.getChild(1).getText(), ctx.getChild(0).getText());
        }
        return visitChildren(ctx);
    }

    /** ParameterList */
    @Override
    public Integer visitParameterList(MiniJavaParser.ParameterListContext ctx) {
        if (VisitCount == 1) {
            Integer temp = 0;
            for (int i = 0; i < ctx.getChildCount(); i+= 2) {
                Parameters.put(CurrentClass + "-" + CurrentMethod + "-" + temp, ctx.getChild(i).getChild(0).getText());
                temp += 1;
            }
            ParameterNum.put(CurrentClass + "-" + CurrentMethod, temp);
        }
        return visitChildren(ctx);
    }
}
