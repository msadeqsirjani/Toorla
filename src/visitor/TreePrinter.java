package visitor;

import assets.Program;
import assets.declaration.description.ClassDeclaration;
import assets.declaration.description.EntryClassDeclaration;
import assets.declaration.description.member.FieldDeclaration;
import assets.declaration.description.member.MethodDeclaration;
import assets.declaration.local.variable.ParameterDeclaration;
import assets.expression.*;
import assets.expression.binaray.*;
import assets.expression.unary.Negative;
import assets.expression.unary.Not;
import assets.expression.value.BooleanValue;
import assets.expression.value.IntegerValue;
import assets.expression.value.StringValue;
import assets.statement.*;
import assets.statement.local.variable.LocalVariableDef;
import assets.statement.local.variable.LocalVariableDefinition;
import assets.statement.returned.Return;

public class TreePrinter implements Visitor<Void> {
    @Override
    public Void visit(And expression) {
        return null;
    }

    @Override
    public Void visit(Division expression) {
        return null;
    }

    @Override
    public Void visit(Equal expression) {
        return null;
    }

    @Override
    public Void visit(GreaterThan expression) {
        return null;
    }

    @Override
    public Void visit(LessThan expression) {
        return null;
    }

    @Override
    public Void visit(Minus expression) {
        return null;
    }

    @Override
    public Void visit(Modulo expression) {
        return null;
    }

    @Override
    public Void visit(NotEqual expression) {
        return null;
    }

    @Override
    public Void visit(Or expression) {
        return null;
    }

    @Override
    public Void visit(Plus expression) {
        return null;
    }

    @Override
    public Void visit(Times expression) {
        return null;
    }

    @Override
    public Void visit(Negative expression) {
        return null;
    }

    @Override
    public Void visit(Not expression) {
        return null;
    }

    @Override
    public Void visit(BooleanValue expression) {
        return null;
    }

    @Override
    public Void visit(IntegerValue expression) {
        return null;
    }

    @Override
    public Void visit(StringValue expression) {
        return null;
    }

    @Override
    public Void visit(ArrayCall expression) {
        return null;
    }

    @Override
    public Void visit(FieldCall expression) {
        return null;
    }

    @Override
    public Void visit(Identifier expression) {
        return null;
    }

    @Override
    public Void visit(MethodCall expression) {
        return null;
    }

    @Override
    public Void visit(NewArray expression) {
        return null;
    }

    @Override
    public Void visit(NewClassInstance expression) {
        return null;
    }

    @Override
    public Void visit(Self expression) {
        return null;
    }

    @Override
    public Void visit(LocalVariableDef statement) {
        return null;
    }

    @Override
    public Void visit(LocalVariableDefinition statement) {
        return null;
    }

    @Override
    public Void visit(Return statement) {
        return null;
    }

    @Override
    public Void visit(Assign statement) {
        return null;
    }

    @Override
    public Void visit(Block statement) {
        return null;
    }

    @Override
    public Void visit(Break statement) {
        return null;
    }

    @Override
    public Void visit(Conditional statement) {
        return null;
    }

    @Override
    public Void visit(Skip statement) {
        return null;
    }

    @Override
    public Void visit(Continue statement) {
        return null;
    }

    @Override
    public Void visit(Decrement statement) {
        return null;
    }

    @Override
    public Void visit(Increment statement) {
        return null;
    }

    @Override
    public Void visit(Print statement) {
        return null;
    }

    @Override
    public Void visit(While statement) {
        return null;
    }

    @Override
    public Void visit(FieldDeclaration declaration) {
        return null;
    }

    @Override
    public Void visit(ParameterDeclaration declaration) {
        return null;
    }

    @Override
    public Void visit(MethodDeclaration declaration) {
        return null;
    }

    @Override
    public Void visit(ClassDeclaration declaration) {
        return null;
    }

    @Override
    public Void visit(EntryClassDeclaration declaration) {
        return null;
    }

    @Override
    public Void visit(Program declaration) {
        return null;
    }
}
