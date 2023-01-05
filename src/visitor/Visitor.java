package visitor;

import assets.Program;
import assets.declaration.description.*;
import assets.declaration.description.member.*;
import assets.declaration.local.variable.*;
import assets.expression.*;
import assets.expression.binaray.*;
import assets.expression.unary.*;
import assets.expression.value.*;
import assets.statement.*;
import assets.statement.local.variable.*;
import assets.statement.returned.*;

public interface Visitor<T> {

    //    Expression
    T visit(And expression);

    T visit(Division expression);

    T visit(Equal expression);

    T visit(GreaterThan expression);

    T visit(LessThan expression);

    T visit(Minus expression);

    T visit(Modulo expression);

    T visit(NotEqual expression);

    T visit(Or expression);

    T visit(Plus expression);

    T visit(Times expression);

    T visit(Negative expression);

    T visit(Not expression);

    T visit(BooleanValue expression);

    T visit(IntegerValue expression);

    T visit(StringValue expression);

    T visit(ArrayCall expression);

    T visit(FieldCall expression);

    T visit(Identifier expression);

    T visit(MethodCall expression);

    T visit(NewArray expression);

    T visit(NewClassInstance expression);

    T visit(Self expression);

    //    Statement
    T visit(LocalVariableDef statement);

    T visit(LocalVariableDefinition statement);

    T visit(Return statement);

    T visit(Assign statement);

    T visit(Block statement);

    T visit(Break statement);

    T visit(Conditional statement);

    T visit(Skip statement);

    T visit(Continue statement);

    T visit(Decrement statement);

    T visit(Increment statement);

    T visit(Print statement);

    T visit(While statement);

//    Declaration
    T visit(FieldDeclaration declaration);

    T visit(ParameterDeclaration declaration);

    T visit(MethodDeclaration declaration);

    T visit(ClassDeclaration declaration);

    T visit(EntryClassDeclaration declaration);

    T visit(Program declaration);


}
