package gen;// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ToorlaParser}.
 */
public interface ToorlaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ToorlaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ToorlaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(ToorlaParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(ToorlaParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#entryClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEntryClassDeclaration(ToorlaParser.EntryClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#entryClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEntryClassDeclaration(ToorlaParser.EntryClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(ToorlaParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(ToorlaParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#access_modifier}.
	 * @param ctx the parse tree
	 */
	void enterAccess_modifier(ToorlaParser.Access_modifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#access_modifier}.
	 * @param ctx the parse tree
	 */
	void exitAccess_modifier(ToorlaParser.Access_modifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(ToorlaParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(ToorlaParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#closedStatement}.
	 * @param ctx the parse tree
	 */
	void enterClosedStatement(ToorlaParser.ClosedStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#closedStatement}.
	 * @param ctx the parse tree
	 */
	void exitClosedStatement(ToorlaParser.ClosedStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#closedConditional}.
	 * @param ctx the parse tree
	 */
	void enterClosedConditional(ToorlaParser.ClosedConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#closedConditional}.
	 * @param ctx the parse tree
	 */
	void exitClosedConditional(ToorlaParser.ClosedConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#openConditional}.
	 * @param ctx the parse tree
	 */
	void enterOpenConditional(ToorlaParser.OpenConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#openConditional}.
	 * @param ctx the parse tree
	 */
	void exitOpenConditional(ToorlaParser.OpenConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#openStatement}.
	 * @param ctx the parse tree
	 */
	void enterOpenStatement(ToorlaParser.OpenStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#openStatement}.
	 * @param ctx the parse tree
	 */
	void exitOpenStatement(ToorlaParser.OpenStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ToorlaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ToorlaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#statementVarDef}.
	 * @param ctx the parse tree
	 */
	void enterStatementVarDef(ToorlaParser.StatementVarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#statementVarDef}.
	 * @param ctx the parse tree
	 */
	void exitStatementVarDef(ToorlaParser.StatementVarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void enterStatementBlock(ToorlaParser.StatementBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void exitStatementBlock(ToorlaParser.StatementBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#statementContinue}.
	 * @param ctx the parse tree
	 */
	void enterStatementContinue(ToorlaParser.StatementContinueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#statementContinue}.
	 * @param ctx the parse tree
	 */
	void exitStatementContinue(ToorlaParser.StatementContinueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#statementBreak}.
	 * @param ctx the parse tree
	 */
	void enterStatementBreak(ToorlaParser.StatementBreakContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#statementBreak}.
	 * @param ctx the parse tree
	 */
	void exitStatementBreak(ToorlaParser.StatementBreakContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#statementReturn}.
	 * @param ctx the parse tree
	 */
	void enterStatementReturn(ToorlaParser.StatementReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#statementReturn}.
	 * @param ctx the parse tree
	 */
	void exitStatementReturn(ToorlaParser.StatementReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#statementClosedLoop}.
	 * @param ctx the parse tree
	 */
	void enterStatementClosedLoop(ToorlaParser.StatementClosedLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#statementClosedLoop}.
	 * @param ctx the parse tree
	 */
	void exitStatementClosedLoop(ToorlaParser.StatementClosedLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#statementOpenLoop}.
	 * @param ctx the parse tree
	 */
	void enterStatementOpenLoop(ToorlaParser.StatementOpenLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#statementOpenLoop}.
	 * @param ctx the parse tree
	 */
	void exitStatementOpenLoop(ToorlaParser.StatementOpenLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#statementWrite}.
	 * @param ctx the parse tree
	 */
	void enterStatementWrite(ToorlaParser.StatementWriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#statementWrite}.
	 * @param ctx the parse tree
	 */
	void exitStatementWrite(ToorlaParser.StatementWriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#statementAssignment}.
	 * @param ctx the parse tree
	 */
	void enterStatementAssignment(ToorlaParser.StatementAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#statementAssignment}.
	 * @param ctx the parse tree
	 */
	void exitStatementAssignment(ToorlaParser.StatementAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#statementInc}.
	 * @param ctx the parse tree
	 */
	void enterStatementInc(ToorlaParser.StatementIncContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#statementInc}.
	 * @param ctx the parse tree
	 */
	void exitStatementInc(ToorlaParser.StatementIncContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#statementDec}.
	 * @param ctx the parse tree
	 */
	void enterStatementDec(ToorlaParser.StatementDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#statementDec}.
	 * @param ctx the parse tree
	 */
	void exitStatementDec(ToorlaParser.StatementDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ToorlaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ToorlaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#expressionOr}.
	 * @param ctx the parse tree
	 */
	void enterExpressionOr(ToorlaParser.ExpressionOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#expressionOr}.
	 * @param ctx the parse tree
	 */
	void exitExpressionOr(ToorlaParser.ExpressionOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#expressionOrTemp}.
	 * @param ctx the parse tree
	 */
	void enterExpressionOrTemp(ToorlaParser.ExpressionOrTempContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#expressionOrTemp}.
	 * @param ctx the parse tree
	 */
	void exitExpressionOrTemp(ToorlaParser.ExpressionOrTempContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#expressionAnd}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAnd(ToorlaParser.ExpressionAndContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#expressionAnd}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAnd(ToorlaParser.ExpressionAndContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#expressionAndTemp}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAndTemp(ToorlaParser.ExpressionAndTempContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#expressionAndTemp}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAndTemp(ToorlaParser.ExpressionAndTempContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#expressionEq}.
	 * @param ctx the parse tree
	 */
	void enterExpressionEq(ToorlaParser.ExpressionEqContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#expressionEq}.
	 * @param ctx the parse tree
	 */
	void exitExpressionEq(ToorlaParser.ExpressionEqContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#expressionEqTemp}.
	 * @param ctx the parse tree
	 */
	void enterExpressionEqTemp(ToorlaParser.ExpressionEqTempContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#expressionEqTemp}.
	 * @param ctx the parse tree
	 */
	void exitExpressionEqTemp(ToorlaParser.ExpressionEqTempContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#expressionCmp}.
	 * @param ctx the parse tree
	 */
	void enterExpressionCmp(ToorlaParser.ExpressionCmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#expressionCmp}.
	 * @param ctx the parse tree
	 */
	void exitExpressionCmp(ToorlaParser.ExpressionCmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#expressionCmpTemp}.
	 * @param ctx the parse tree
	 */
	void enterExpressionCmpTemp(ToorlaParser.ExpressionCmpTempContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#expressionCmpTemp}.
	 * @param ctx the parse tree
	 */
	void exitExpressionCmpTemp(ToorlaParser.ExpressionCmpTempContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#expressionAdd}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAdd(ToorlaParser.ExpressionAddContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#expressionAdd}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAdd(ToorlaParser.ExpressionAddContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#expressionAddTemp}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAddTemp(ToorlaParser.ExpressionAddTempContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#expressionAddTemp}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAddTemp(ToorlaParser.ExpressionAddTempContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#expressionMultMod}.
	 * @param ctx the parse tree
	 */
	void enterExpressionMultMod(ToorlaParser.ExpressionMultModContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#expressionMultMod}.
	 * @param ctx the parse tree
	 */
	void exitExpressionMultMod(ToorlaParser.ExpressionMultModContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#expressionMultModTemp}.
	 * @param ctx the parse tree
	 */
	void enterExpressionMultModTemp(ToorlaParser.ExpressionMultModTempContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#expressionMultModTemp}.
	 * @param ctx the parse tree
	 */
	void exitExpressionMultModTemp(ToorlaParser.ExpressionMultModTempContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#expressionUnary}.
	 * @param ctx the parse tree
	 */
	void enterExpressionUnary(ToorlaParser.ExpressionUnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#expressionUnary}.
	 * @param ctx the parse tree
	 */
	void exitExpressionUnary(ToorlaParser.ExpressionUnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#expressionMethods}.
	 * @param ctx the parse tree
	 */
	void enterExpressionMethods(ToorlaParser.ExpressionMethodsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#expressionMethods}.
	 * @param ctx the parse tree
	 */
	void exitExpressionMethods(ToorlaParser.ExpressionMethodsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#expressionMethodsTemp}.
	 * @param ctx the parse tree
	 */
	void enterExpressionMethodsTemp(ToorlaParser.ExpressionMethodsTempContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#expressionMethodsTemp}.
	 * @param ctx the parse tree
	 */
	void exitExpressionMethodsTemp(ToorlaParser.ExpressionMethodsTempContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#expressionOther}.
	 * @param ctx the parse tree
	 */
	void enterExpressionOther(ToorlaParser.ExpressionOtherContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#expressionOther}.
	 * @param ctx the parse tree
	 */
	void exitExpressionOther(ToorlaParser.ExpressionOtherContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#toorlaType}.
	 * @param ctx the parse tree
	 */
	void enterToorlaType(ToorlaParser.ToorlaTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#toorlaType}.
	 * @param ctx the parse tree
	 */
	void exitToorlaType(ToorlaParser.ToorlaTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ToorlaParser#singleType}.
	 * @param ctx the parse tree
	 */
	void enterSingleType(ToorlaParser.SingleTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ToorlaParser#singleType}.
	 * @param ctx the parse tree
	 */
	void exitSingleType(ToorlaParser.SingleTypeContext ctx);
}