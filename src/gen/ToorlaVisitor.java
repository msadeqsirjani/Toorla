package gen;// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ToorlaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ToorlaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ToorlaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(ToorlaParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#entryClassDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntryClassDeclaration(ToorlaParser.EntryClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(ToorlaParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#access_modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccess_modifier(ToorlaParser.Access_modifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(ToorlaParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#closedStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosedStatement(ToorlaParser.ClosedStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#closedConditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosedConditional(ToorlaParser.ClosedConditionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#openConditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenConditional(ToorlaParser.OpenConditionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#openStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenStatement(ToorlaParser.OpenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ToorlaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#statementVarDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementVarDef(ToorlaParser.StatementVarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#statementBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBlock(ToorlaParser.StatementBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#statementContinue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementContinue(ToorlaParser.StatementContinueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#statementBreak}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBreak(ToorlaParser.StatementBreakContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#statementReturn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementReturn(ToorlaParser.StatementReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#statementClosedLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementClosedLoop(ToorlaParser.StatementClosedLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#statementOpenLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementOpenLoop(ToorlaParser.StatementOpenLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#statementWrite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWrite(ToorlaParser.StatementWriteContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#statementAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementAssignment(ToorlaParser.StatementAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#statementInc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementInc(ToorlaParser.StatementIncContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#statementDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementDec(ToorlaParser.StatementDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ToorlaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#expressionOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionOr(ToorlaParser.ExpressionOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#expressionOrTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionOrTemp(ToorlaParser.ExpressionOrTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#expressionAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAnd(ToorlaParser.ExpressionAndContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#expressionAndTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAndTemp(ToorlaParser.ExpressionAndTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#expressionEq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionEq(ToorlaParser.ExpressionEqContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#expressionEqTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionEqTemp(ToorlaParser.ExpressionEqTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#expressionCmp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionCmp(ToorlaParser.ExpressionCmpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#expressionCmpTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionCmpTemp(ToorlaParser.ExpressionCmpTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#expressionAdd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAdd(ToorlaParser.ExpressionAddContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#expressionAddTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAddTemp(ToorlaParser.ExpressionAddTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#expressionMultMod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionMultMod(ToorlaParser.ExpressionMultModContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#expressionMultModTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionMultModTemp(ToorlaParser.ExpressionMultModTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#expressionUnary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionUnary(ToorlaParser.ExpressionUnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#expressionMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionMethods(ToorlaParser.ExpressionMethodsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#expressionMethodsTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionMethodsTemp(ToorlaParser.ExpressionMethodsTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#expressionOther}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionOther(ToorlaParser.ExpressionOtherContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#toorlaType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToorlaType(ToorlaParser.ToorlaTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ToorlaParser#singleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleType(ToorlaParser.SingleTypeContext ctx);
}