package ananlyzer;

import ananlyzer.errors.*;
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
import symbol.table.exceptions.ItemAlreadyExistsException;
import symbol.table.items.ClassSymbolTableItem;
import symbol.table.items.MethodSymbolTableItem;
import symbol.table.items.variables.FieldSymbolTableItem;
import symbol.table.items.variables.LocalVariableSymbolTableItem;
import types.Type;
import visitor.Visitor;

import java.util.ArrayList;

public class NameCollectionPass implements Visitor<Void>, INameAnalyzingPass<Void> {
    private int newLocalVarIndex;// refreshed in start of every method
    private int classCounter = 0;

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
        SymbolTable.push(new SymbolTable(SymbolTable.top()));
        for (Statement stmt : block.body)
            stmt.accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(Conditional conditional) {
        SymbolTable.push(new SymbolTable(SymbolTable.top()));
        conditional.getThenStatement().accept(this);
        SymbolTable.pop();
        SymbolTable.push(new SymbolTable(SymbolTable.top()));
        conditional.getElseStatement().accept(this);
        SymbolTable.pop();
        return null;

    }

    @Override
    public Void visit(While whileStat) {
        SymbolTable.push(new SymbolTable(SymbolTable.top()));
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
        try {
            SymbolTable.top().put(new LocalVariableSymbolTableItem(localVariableDef.getLocalVarName().getName(), newLocalVarIndex));
        } catch (ItemAlreadyExistsException e) {
            LocalVariableRedefinitionException ee = new LocalVariableRedefinitionException(localVariableDef.getLocalVarName().getName(), localVariableDef.line, localVariableDef.col);
            localVariableDef.relatedErrors.add(ee);
        }
        newLocalVarIndex++;
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
        classCounter++;
        ClassSymbolTableItem thisClass = new ClassSymbolTableItem(classDeclaration.getName().getName());
        SymbolTable.push(new SymbolTable(SymbolTable.top()));
        try {
            thisClass.setSymbolTable(SymbolTable.top());
            thisClass.setParentSymbolTable(SymbolTable.top().getPreSymbolTable());
            SymbolTable.root.put(thisClass);
        } catch (ItemAlreadyExistsException e) {
            ClassRedefinitionException ee = new ClassRedefinitionException(classDeclaration, classCounter);
            ee.handle();
            classDeclaration.relatedErrors.add(ee);
        }
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
        if (!fieldDeclaration.getIdentifier().getName().equals("length")) {
            try {
                SymbolTable.top().put(new FieldSymbolTableItem(fieldDeclaration.getIdentifier().getName(), fieldDeclaration.getAccessModifier(), fieldDeclaration.getType()));
            } catch (ItemAlreadyExistsException e) {
                FieldRedefinitionException ee = new FieldRedefinitionException(fieldDeclaration.getIdentifier().getName(), fieldDeclaration.line, fieldDeclaration.col);
                fieldDeclaration.relatedErrors.add(ee);
            }
        } else {
            FieldNamedLengthDeclarationException e = new FieldNamedLengthDeclarationException(fieldDeclaration.getIdentifier().line, fieldDeclaration.getIdentifier().col);
            fieldDeclaration.relatedErrors.add(e);
        }
        return null;
    }

    @Override
    public Void visit(ParameterDeclaration parameterDeclaration) {
        try {
            SymbolTable.top().put(new LocalVariableSymbolTableItem(parameterDeclaration.getIdentifier().getName(), newLocalVarIndex));
        } catch (ItemAlreadyExistsException e) {
            LocalVariableRedefinitionException ee = new LocalVariableRedefinitionException(parameterDeclaration.getIdentifier().getName(), parameterDeclaration.line, parameterDeclaration.col);
            parameterDeclaration.relatedErrors.add(ee);
        }
        newLocalVarIndex++;
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        newLocalVarIndex = 1;
        try {
            ArrayList<Type> argumentsTypes = new ArrayList<>();

            for (var arg : methodDeclaration.getArguments()) {
                argumentsTypes.add(arg.getType());
            }

            SymbolTable.top().put(new MethodSymbolTableItem(methodDeclaration.getName().getName(), methodDeclaration.getReturnType(), argumentsTypes, methodDeclaration.getAccessModifier()));
        } catch (ItemAlreadyExistsException e) {
            MethodRedefinitionException ee = new MethodRedefinitionException(methodDeclaration.getName().getName(), methodDeclaration.getName().line, methodDeclaration.getName().col);
            methodDeclaration.relatedErrors.add(ee);
        }
        SymbolTable.push(new SymbolTable(SymbolTable.top()));

        for (var parameter : methodDeclaration.getArguments()) {
            parameter.accept(this);
        }

        for (var body : methodDeclaration.getBody()) {
            body.accept(this);
        }
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(LocalVariableDefinitions localVariableDefinitions) {
        for (var variable : localVariableDefinitions.getVarDefinitions()) {
            variable.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(Program program) {
        for (var thisClass : program.getClasses()) {
            thisClass.accept(this);
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
