package visitor;

import assets.Program;
import assets.declarations.classes.ClassDeclaration;
import assets.declarations.classes.EntryClassDeclaration;
import assets.declarations.classes.members.FieldDeclaration;
import assets.declarations.classes.members.MethodDeclaration;
import assets.declarations.variables.ParameterDeclaration;
import assets.expressions.*;
import assets.expressions.binaries.*;
import assets.expressions.unaries.Negative;
import assets.expressions.unaries.Not;
import assets.expressions.value.BoolValue;
import assets.expressions.value.IntValue;
import assets.expressions.value.StringValue;
import assets.statements.*;
import assets.statements.returned.Return;
import assets.statements.variables.LocalVariableDef;
import assets.statements.variables.LocalVariableDefinitions;


public interface Visitor<T> {
    // Statement
    T visit(Print printStat);

    T visit(Assign assignStat);

    T visit(Block block);

    T visit(Conditional conditional);

    T visit(While whileStat);

    T visit(Return returnStat);

    T visit(Break breakStat);

    T visit(Continue continueStat);

    T visit(Skip skip);

    T visit(LocalVariableDef localVariableDef);

    T visit(Increment increment);

    T visit(Decrement decrement);


    // Expression
    T visit(Plus plusExpr);

    T visit(Minus minusExpr);

    T visit(Times timesExpr);

    T visit(Division divExpr);

    T visit(Modulo moduloExpr);

    T visit(Equals equalsExpr);

    T visit(GreaterThan gtExpr);

    T visit(LessThan lessThanExpr);

    T visit(And andExpr);

    T visit(Or orExpr);

    T visit(Negative negativeExpr);

    T visit(Not notExpr);

    T visit(MethodCall methodCall);

    T visit(Identifier identifier);

    T visit(Self self);

    T visit(IntValue intValue);

    T visit(NewArray newArray);

    T visit(BoolValue booleanValue);

    T visit(StringValue stringValue);

    T visit(NewClassInstance newClassInstance);

    T visit(FieldCall fieldCall);

    T visit(ArrayCall arrayCall);

    T visit(NotEquals notEquals);

    //declarations
    T visit(ClassDeclaration classDeclaration);

    T visit(EntryClassDeclaration entryClassDeclaration);

    T visit(FieldDeclaration fieldDeclaration);

    T visit(ParameterDeclaration parameterDeclaration);

    T visit(MethodDeclaration methodDeclaration);

    T visit(LocalVariableDefinitions localVariableDefinitions);

    T visit(Program program);

}