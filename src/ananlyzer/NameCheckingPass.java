package ananlyzer;

import ananlyzer.errors.FieldRedefinitionException;
import ananlyzer.errors.MethodRedefinitionException;
import assets.Program;
import assets.declarations.classes.ClassDeclaration;
import assets.declarations.classes.EntryClassDeclaration;
import assets.declarations.classes.members.ClassMemberDeclaration;
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
import symbol.table.SymbolTable;
import symbol.table.exceptions.ItemNotFoundException;
import symbol.table.items.MethodSymbolTableItem;
import symbol.table.items.SymbolTableItem;
import symbol.table.items.variables.VariableSymbolTableItem;
import visitor.Visitor;

public class NameCheckingPass implements Visitor<Void>, INameAnalyzingPass<Void> {

    @Override
    public Void visit(Print printStat) {
        return null;
    }

    @Override
    public Void visit(Assign assignStat) {
        return null;
    }

    @Override
    public Void visit(Block block) {
        SymbolTable.pushFromQueue();
        for (Statement stmt : block.body)
            stmt.accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(Conditional conditional) {
        SymbolTable.pushFromQueue();
        conditional.getThenStatement().accept(this);
        SymbolTable.pop();
        SymbolTable.pushFromQueue();
        conditional.getElseStatement().accept(this);
        SymbolTable.pop();
        return null;

    }

    @Override
    public Void visit(While whileStat) {
        SymbolTable.pushFromQueue();
        whileStat.body.accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(Return returnStat) {
        return null;
    }

    @Override
    public Void visit(Break breakStat) {

        return null;
    }

    @Override
    public Void visit(Continue continueStat) {
        return null;
    }

    @Override
    public Void visit(Skip skip) {
        return null;
    }

    @Override
    public Void visit(LocalVariableDef localVariableDef) {
        return null;
    }

    @Override
    public Void visit(Increment increment) {
        return null;
    }

    @Override
    public Void visit(Decrement decrement) {
        return null;
    }

    @Override
    public Void visit(Plus plusExpr) {
        return null;
    }

    @Override
    public Void visit(Minus minusExpr) {
        return null;
    }

    @Override
    public Void visit(Times timesExpr) {
        return null;
    }

    @Override
    public Void visit(Division divExpr) {
        return null;
    }

    @Override
    public Void visit(Modulo moduloExpr) {
        return null;
    }

    @Override
    public Void visit(Equals equalsExpr) {
        return null;
    }

    @Override
    public Void visit(GreaterThan gtExpr) {
        return null;
    }

    @Override
    public Void visit(LessThan lessThanExpr) {
        return null;
    }

    @Override
    public Void visit(And andExpr) {
        return null;
    }

    @Override
    public Void visit(Or orExpr) {
        return null;
    }

    @Override
    public Void visit(Negative negativeExpr) {
        return null;
    }

    @Override
    public Void visit(Not notExpr) {
        return null;
    }

    @Override
    public Void visit(MethodCall methodCall) {
        return null;
    }

    @Override
    public Void visit(Identifier identifier) {
        return null;
    }

    @Override
    public Void visit(Self self) {
        return null;
    }

    @Override
    public Void visit(IntValue intValue) {
        return null;
    }

    @Override
    public Void visit(NewArray newArray) {
        return null;
    }

    @Override
    public Void visit(BoolValue booleanValue) {
        return null;
    }

    @Override
    public Void visit(StringValue stringValue) {
        return null;
    }

    @Override
    public Void visit(NewClassInstance newClassInstance) {
        return null;
    }

    @Override
    public Void visit(FieldCall fieldCall) {
        return null;
    }

    @Override
    public Void visit(ArrayCall arrayCall) {
        return null;
    }

    @Override
    public Void visit(NotEquals notEquals) {
        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        SymbolTable.pushFromQueue();
        for (ClassMemberDeclaration cmd : classDeclaration.getClassMembers())
            cmd.accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(EntryClassDeclaration entryClassDeclaration) {
        this.visit((ClassDeclaration) entryClassDeclaration);
        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDeclaration) {
        if (fieldDeclaration.relatedErrors.size() == 0) try {
            SymbolTableItem sameFieldInParents = SymbolTable.top().getInParentScopes(VariableSymbolTableItem.var_modifier + fieldDeclaration.getIdentifier().getName());
            FieldRedefinitionException e = new FieldRedefinitionException(fieldDeclaration.getIdentifier().getName(), fieldDeclaration.line, fieldDeclaration.col);
            fieldDeclaration.relatedErrors.add(e);
        } catch (ItemNotFoundException ignored) {
        }
        return null;
    }

    @Override
    public Void visit(ParameterDeclaration parameterDeclaration) {
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        if (methodDeclaration.relatedErrors.size() == 0) try {
            SymbolTableItem sameMethodInParents = SymbolTable.top().getInParentScopes(MethodSymbolTableItem.methodModifier + methodDeclaration.getName().getName());
            MethodRedefinitionException e = new MethodRedefinitionException(methodDeclaration.getName().getName(), methodDeclaration.getName().line, methodDeclaration.getName().col);
            methodDeclaration.relatedErrors.add(e);
        } catch (ItemNotFoundException ignored) {
        }
        SymbolTable.pushFromQueue();

        for (var parameter : methodDeclaration.getArguments()) {
            parameter.accept(this);
        }

        for (var statement : methodDeclaration.getBody()) {
            statement.accept(this);
        }
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(LocalVariableDefinitions localVariableDefinitions) {
        for (LocalVariableDef lvd : localVariableDefinitions.getVarDefinitions()) {
            lvd.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Program program) {
        SymbolTable.pushFromQueue();
        for (ClassDeclaration cd : program.getClasses()) {
            cd.accept(this);
        }
        SymbolTable.pop();
        return null;
    }

    @Override
    public void analyze(Program program) {
        this.visit(program);
    }

    @Override
    public Void getResult() {
        return null;
    }
}
