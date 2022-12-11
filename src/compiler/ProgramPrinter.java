package compiler;

import gen.ToorlaListener;
import gen.ToorlaParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import utilities.GlobalExtension;

public class ProgramPrinter implements ToorlaListener {

    private int indentation = 0;

    public int getIndentation() {
        return this.indentation;
    }

    public void setIndentation(int indentation) {
        this.indentation = indentation;
    }

    private String className;

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    private String classParent;

    public String getClassParent() {
        return this.classParent;
    }

    public void setClassParent(String classParent) {
        this.classParent = classParent;
    }

    private boolean isEntry;

    public boolean getIsEntry() {
        return this.isEntry;
    }

    public void setIsEntry(boolean isEntry) {
        this.isEntry = isEntry;
    }

    @Override
    public void enterProgram(ToorlaParser.ProgramContext ctx) {
        System.out.println("program start {");
        setIndentation(0);
    }

    @Override
    public void exitProgram(ToorlaParser.ProgramContext ctx) {
        setIndentation(0);
        System.out.println("}");
    }

    @Override
    public void enterClassDeclaration(ToorlaParser.ClassDeclarationContext ctx) {
        setIndentation(1);
        setIsEntry(GlobalExtension.isEntryClass(ctx.methodDeclaration()));

        if (getIsEntry()) return;

        setClassName(ctx.className.getText());
        setClassParent(ctx.classParent == null ? "none" : ctx.classParent.getText());

        System.out.print(GlobalExtension.tabbedString(getIndentation()));
        System.out.printf("class: %s / class parent: %s / isEntry: %b {", getClassName(), this.getClassParent(), getIsEntry());
        System.out.println();
    }

    @Override
    public void exitClassDeclaration(ToorlaParser.ClassDeclarationContext ctx) {
        if (getIsEntry()) return;
        setIndentation(1);
        System.out.println(GlobalExtension.tabbedString(getIndentation()) + "}");
    }

    @Override
    public void enterEntryClassDeclaration(ToorlaParser.EntryClassDeclarationContext ctx) {
        var context = ctx.classDeclaration();

        setIndentation(1);
        setIsEntry(GlobalExtension.isEntryClass(context.methodDeclaration()));
        if (!getIsEntry()) return;

        setClassName(context.className.getText());
        setClassParent(context.classParent == null ? "none" : context.classParent.getText());

        System.out.print(GlobalExtension.tabbedString(getIndentation()));
        System.out.printf("class: %s / class parents: %s / isEntry: %b {", getClassName(), getClassParent(), getIsEntry());
        System.out.println();
    }

    @Override
    public void exitEntryClassDeclaration(ToorlaParser.EntryClassDeclarationContext ctx) {
        var context = ctx.classDeclaration();

        if (!GlobalExtension.isEntryClass(context.methodDeclaration())) return;

        setIndentation(1);
        System.out.println(GlobalExtension.tabbedString(getIndentation()) + "}");
    }

    @Override
    public void enterFieldDeclaration(ToorlaParser.FieldDeclarationContext ctx) {
        setIndentation(2);
        System.out.print(GlobalExtension.tabbedString(getIndentation()));
        System.out.printf("filed: %s / type: %s", ctx.fieldName.getText(), ctx.fieldType.st.getText());
    }

    @Override
    public void exitFieldDeclaration(ToorlaParser.FieldDeclarationContext ctx) {
        setIndentation(2);
        System.out.println();
    }

    @Override
    public void enterAccess_modifier(ToorlaParser.Access_modifierContext ctx) {

    }

    @Override
    public void exitAccess_modifier(ToorlaParser.Access_modifierContext ctx) {

    }

    @Override
    public void enterMethodDeclaration(ToorlaParser.MethodDeclarationContext ctx) {
        setIndentation(2);
        System.out.print(GlobalExtension.tabbedString(getIndentation()));

        String MAIN = "main";
        if (getIsEntry() && ctx.methodName.getText().equals(MAIN)) {
            System.out.printf("main method / type %s {\n", ctx.t.st.getText());
            setIndentation(3);
            return;
        }

        if (ctx.methodName.getText().equals(getClassName())) {
            System.out.printf("class constructor: %s / return type: %s / type: %s {\n", ctx.methodName.getText(),
                    ctx.t.st.getText(), ctx.methodAccessModifier.getText());
        } else {
            System.out.printf("class method: %s / return type: %s / type: %s {\n", ctx.methodName.getText(),
                    ctx.t.st.getText(), ctx.methodAccessModifier.getText());

        }

        GlobalExtension.prepareParameterList(ctx);

        setIndentation(3);
    }

    @Override
    public void exitMethodDeclaration(ToorlaParser.MethodDeclarationContext ctx) {
        setIndentation(2);
        System.out.print(GlobalExtension.tabbedString(getIndentation()) + "}");
        System.out.println();
    }

    @Override
    public void enterClosedStatement(ToorlaParser.ClosedStatementContext ctx) {

    }

    @Override
    public void exitClosedStatement(ToorlaParser.ClosedStatementContext ctx) {

    }

    @Override
    public void enterClosedConditional(ToorlaParser.ClosedConditionalContext ctx) {
    }

    @Override
    public void exitClosedConditional(ToorlaParser.ClosedConditionalContext ctx) {
    }

    @Override
    public void enterOpenConditional(ToorlaParser.OpenConditionalContext ctx) {

    }

    @Override
    public void exitOpenConditional(ToorlaParser.OpenConditionalContext ctx) {

    }

    @Override
    public void enterOpenStatement(ToorlaParser.OpenStatementContext ctx) {

    }

    @Override
    public void exitOpenStatement(ToorlaParser.OpenStatementContext ctx) {

    }

    @Override
    public void enterStatement(ToorlaParser.StatementContext ctx) {

    }

    @Override
    public void exitStatement(ToorlaParser.StatementContext ctx) {

    }

    @Override
    public void enterStatementVarDef(ToorlaParser.StatementVarDefContext ctx) {
        System.out.printf(GlobalExtension.tabbedString(getIndentation()) + "field: %s / type: local var", ctx.i1.getText());
    }

    @Override
    public void exitStatementVarDef(ToorlaParser.StatementVarDefContext ctx) {
        System.out.println();
    }

    @Override
    public void enterStatementBlock(ToorlaParser.StatementBlockContext ctx) {
        if (!getIsEntry()) {
            System.out.println(GlobalExtension.tabbedString(getIndentation()) + "nested {");
            setIndentation(4);
        }
    }

    @Override
    public void exitStatementBlock(ToorlaParser.StatementBlockContext ctx) {
        if (!getIsEntry()) {
            setIndentation(3);
            System.out.println(GlobalExtension.tabbedString(getIndentation()) + "}");
        }
    }

    @Override
    public void enterStatementContinue(ToorlaParser.StatementContinueContext ctx) {

    }

    @Override
    public void exitStatementContinue(ToorlaParser.StatementContinueContext ctx) {

    }

    @Override
    public void enterStatementBreak(ToorlaParser.StatementBreakContext ctx) {

    }

    @Override
    public void exitStatementBreak(ToorlaParser.StatementBreakContext ctx) {

    }

    @Override
    public void enterStatementReturn(ToorlaParser.StatementReturnContext ctx) {

    }

    @Override
    public void exitStatementReturn(ToorlaParser.StatementReturnContext ctx) {

    }

    @Override
    public void enterStatementClosedLoop(ToorlaParser.StatementClosedLoopContext ctx) {

    }

    @Override
    public void exitStatementClosedLoop(ToorlaParser.StatementClosedLoopContext ctx) {

    }

    @Override
    public void enterStatementOpenLoop(ToorlaParser.StatementOpenLoopContext ctx) {
        System.out.println("nested {");
    }

    @Override
    public void exitStatementOpenLoop(ToorlaParser.StatementOpenLoopContext ctx) {
        System.out.println("}");
    }

    @Override
    public void enterStatementWrite(ToorlaParser.StatementWriteContext ctx) {

    }

    @Override
    public void exitStatementWrite(ToorlaParser.StatementWriteContext ctx) {

    }

    @Override
    public void enterStatementAssignment(ToorlaParser.StatementAssignmentContext ctx) {
        setIndentation(3);

        var leftExpression = ctx.expression().get(0)
                .expressionOr()
                .expressionAnd()
                .expressionEq()
                .expressionCmp()
                .expressionAdd()
                .expressionMultMod()
                .expressionUnary()
                .expressionMethods()
                .expressionOther();;

        var rightExpression = ctx.expression().get(1)
                .expressionOr()
                .expressionAnd()
                .expressionEq()
                .expressionCmp()
                .expressionAdd()
                .expressionMultMod()
                .expressionUnary()
                .expressionMethods()
                .expressionOther();

        if (rightExpression.st != null) {
            System.out.println(GlobalExtension.tabbedString(getIndentation()) + String.format("field: %s / type: %s[]", leftExpression.i1.getText(), rightExpression.st.getText()));
        }

        if (rightExpression.i != null) {
            System.out.println(GlobalExtension.tabbedString(getIndentation()) + String.format("field: %s / type: %s", leftExpression.i1.getText(), rightExpression.i.getText()));
        }
    }

    @Override
    public void exitStatementAssignment(ToorlaParser.StatementAssignmentContext ctx) {

    }

    @Override
    public void enterStatementInc(ToorlaParser.StatementIncContext ctx) {

    }

    @Override
    public void exitStatementInc(ToorlaParser.StatementIncContext ctx) {

    }

    @Override
    public void enterStatementDec(ToorlaParser.StatementDecContext ctx) {

    }

    @Override
    public void exitStatementDec(ToorlaParser.StatementDecContext ctx) {

    }

    @Override
    public void enterExpression(ToorlaParser.ExpressionContext ctx) {

    }

    @Override
    public void exitExpression(ToorlaParser.ExpressionContext ctx) {

    }

    @Override
    public void enterExpressionOr(ToorlaParser.ExpressionOrContext ctx) {

    }

    @Override
    public void exitExpressionOr(ToorlaParser.ExpressionOrContext ctx) {

    }

    @Override
    public void enterExpressionOrTemp(ToorlaParser.ExpressionOrTempContext ctx) {

    }

    @Override
    public void exitExpressionOrTemp(ToorlaParser.ExpressionOrTempContext ctx) {

    }

    @Override
    public void enterExpressionAnd(ToorlaParser.ExpressionAndContext ctx) {

    }

    @Override
    public void exitExpressionAnd(ToorlaParser.ExpressionAndContext ctx) {

    }

    @Override
    public void enterExpressionAndTemp(ToorlaParser.ExpressionAndTempContext ctx) {

    }

    @Override
    public void exitExpressionAndTemp(ToorlaParser.ExpressionAndTempContext ctx) {

    }

    @Override
    public void enterExpressionEq(ToorlaParser.ExpressionEqContext ctx) {

    }

    @Override
    public void exitExpressionEq(ToorlaParser.ExpressionEqContext ctx) {

    }

    @Override
    public void enterExpressionEqTemp(ToorlaParser.ExpressionEqTempContext ctx) {

    }

    @Override
    public void exitExpressionEqTemp(ToorlaParser.ExpressionEqTempContext ctx) {

    }

    @Override
    public void enterExpressionCmp(ToorlaParser.ExpressionCmpContext ctx) {

    }

    @Override
    public void exitExpressionCmp(ToorlaParser.ExpressionCmpContext ctx) {

    }

    @Override
    public void enterExpressionCmpTemp(ToorlaParser.ExpressionCmpTempContext ctx) {

    }

    @Override
    public void exitExpressionCmpTemp(ToorlaParser.ExpressionCmpTempContext ctx) {

    }

    @Override
    public void enterExpressionAdd(ToorlaParser.ExpressionAddContext ctx) {

    }

    @Override
    public void exitExpressionAdd(ToorlaParser.ExpressionAddContext ctx) {

    }

    @Override
    public void enterExpressionAddTemp(ToorlaParser.ExpressionAddTempContext ctx) {

    }

    @Override
    public void exitExpressionAddTemp(ToorlaParser.ExpressionAddTempContext ctx) {

    }

    @Override
    public void enterExpressionMultMod(ToorlaParser.ExpressionMultModContext ctx) {

    }

    @Override
    public void exitExpressionMultMod(ToorlaParser.ExpressionMultModContext ctx) {

    }

    @Override
    public void enterExpressionMultModTemp(ToorlaParser.ExpressionMultModTempContext ctx) {

    }

    @Override
    public void exitExpressionMultModTemp(ToorlaParser.ExpressionMultModTempContext ctx) {

    }

    @Override
    public void enterExpressionUnary(ToorlaParser.ExpressionUnaryContext ctx) {

    }

    @Override
    public void exitExpressionUnary(ToorlaParser.ExpressionUnaryContext ctx) {

    }

    @Override
    public void enterExpressionMethods(ToorlaParser.ExpressionMethodsContext ctx) {

    }

    @Override
    public void exitExpressionMethods(ToorlaParser.ExpressionMethodsContext ctx) {

    }

    @Override
    public void enterExpressionMethodsTemp(ToorlaParser.ExpressionMethodsTempContext ctx) {

    }

    @Override
    public void exitExpressionMethodsTemp(ToorlaParser.ExpressionMethodsTempContext ctx) {

    }

    @Override
    public void enterExpressionOther(ToorlaParser.ExpressionOtherContext ctx) {

    }

    @Override
    public void exitExpressionOther(ToorlaParser.ExpressionOtherContext ctx) {

    }

    @Override
    public void enterToorlaType(ToorlaParser.ToorlaTypeContext ctx) {

    }

    @Override
    public void exitToorlaType(ToorlaParser.ToorlaTypeContext ctx) {

    }

    @Override
    public void enterSingleType(ToorlaParser.SingleTypeContext ctx) {

    }

    @Override
    public void exitSingleType(ToorlaParser.SingleTypeContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
