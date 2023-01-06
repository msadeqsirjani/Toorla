package ananlyzer;

import ananlyzer.errors.CompileErrorException;
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
import visitor.Visitor;

public class ReportingPass implements Visitor<Integer>, INameAnalyzingPass<Void> {

    @Override
    public Integer visit(Print printStat) {
        return 0;
    }

    @Override
    public Integer visit(Assign assignStat) {
        return 0;
    }

    @Override
    public Integer visit(Block block) {
        int numOfErrors = 0;
        for (Statement stmt : block.body)
            numOfErrors += stmt.accept(this);
        return numOfErrors;
    }

    @Override
    public Integer visit(Conditional conditional) {
        return conditional.getThenStatement().accept(this) + conditional.getElseStatement().accept(this);
    }

    @Override
    public Integer visit(While whileStat) {
        return whileStat.body.accept(this);
    }

    @Override
    public Integer visit(Return returnStat) {
        return 0;
    }

    @Override
    public Integer visit(Break breakStat) {
        return 0;
    }

    @Override
    public Integer visit(Continue continueStat) {
        return 0;
    }

    @Override
    public Integer visit(Skip skip) {
        return 0;
    }

    @Override
    public Integer visit(LocalVariableDef localVariableDef) {
        for (CompileErrorException e : localVariableDef.relatedErrors) {
            System.out.println(e);
        }
        return localVariableDef.relatedErrors.size();
    }

    @Override
    public Integer visit(Increment increment) {
        return 0;
    }

    @Override
    public Integer visit(Decrement decrement) {
        return 0;
    }

    @Override
    public Integer visit(Plus plusExpr) {
        return 0;
    }

    @Override
    public Integer visit(Minus minusExpr) {
        return 0;
    }

    @Override
    public Integer visit(Times timesExpr) {
        return 0;
    }

    @Override
    public Integer visit(Division divExpr) {
        return 0;
    }

    @Override
    public Integer visit(Modulo moduloExpr) {
        return 0;
    }

    @Override
    public Integer visit(Equals equalsExpr) {
        return 0;
    }

    @Override
    public Integer visit(GreaterThan gtExpr) {
        return 0;
    }

    @Override
    public Integer visit(LessThan lessThanExpr) {
        return 0;
    }

    @Override
    public Integer visit(And andExpr) {
        return 0;
    }

    @Override
    public Integer visit(Or orExpr) {
        return 0;
    }

    @Override
    public Integer visit(Negative negativeExpr) {
        return 0;
    }

    @Override
    public Integer visit(Not notExpr) {
        return 0;
    }

    @Override
    public Integer visit(MethodCall methodCall) {
        return 0;
    }

    @Override
    public Integer visit(Identifier identifier) {
        return 0;
    }

    @Override
    public Integer visit(Self self) {
        return 0;
    }

    @Override
    public Integer visit(IntValue intValue) {
        return 0;
    }

    @Override
    public Integer visit(NewArray newArray) {
        return 0;
    }

    @Override
    public Integer visit(BoolValue booleanValue) {
        return 0;
    }

    @Override
    public Integer visit(StringValue stringValue) {
        return 0;
    }

    @Override
    public Integer visit(NewClassInstance newClassInstance) {
        return 0;
    }

    @Override
    public Integer visit(FieldCall fieldCall) {
        return 0;
    }

    @Override
    public Integer visit(ArrayCall arrayCall) {
        return 0;
    }

    @Override
    public Integer visit(NotEquals notEquals) {
        return 0;
    }

    @Override
    public Integer visit(ClassDeclaration classDeclaration) {
        int numOfErrors = classDeclaration.relatedErrors.size();
        for (CompileErrorException e : classDeclaration.relatedErrors) {
            System.out.println(e);
        }
        for (ClassMemberDeclaration cmd : classDeclaration.getClassMembers())
            numOfErrors += cmd.accept(this);
        return numOfErrors;
    }

    @Override
    public Integer visit(EntryClassDeclaration entryClassDeclaration) {
        return this.visit((ClassDeclaration) entryClassDeclaration);
    }

    @Override
    public Integer visit(FieldDeclaration fieldDeclaration) {
        for (CompileErrorException e : fieldDeclaration.relatedErrors) {
            System.out.println(e);
        }
        return fieldDeclaration.relatedErrors.size();
    }

    @Override
    public Integer visit(ParameterDeclaration parameterDeclaration) {
        for (CompileErrorException e : parameterDeclaration.relatedErrors) {
            System.out.println(e);
        }
        return parameterDeclaration.relatedErrors.size();
    }

    @Override
    public Integer visit(MethodDeclaration methodDeclaration) {
        int errors = methodDeclaration.relatedErrors.size();

        for (CompileErrorException e : methodDeclaration.relatedErrors) {
            System.out.println(e);
        }

        for (var parameter : methodDeclaration.getArguments()) {
            errors += parameter.accept(this);
        }

        for (var statement : methodDeclaration.getBody()) {
//            if (statement != null) {
                errors += statement.accept(this);
//            }
        }

        return errors;
    }

    @Override
    public Integer visit(LocalVariableDefinitions localVariableDefinitions) {
        int numOfErrors = 0;
        for (LocalVariableDef lvd : localVariableDefinitions.getVarDefinitions()) {
            numOfErrors += lvd.accept(this);
        }
        return numOfErrors;
    }

    @Override
    public Integer visit(Program program) {
        int numOfErrors = program.relatedErrors.size();
        for (CompileErrorException e : program.relatedErrors) {
            System.out.println(e);
        }
        for (ClassDeclaration cd : program.getClasses()) {
            numOfErrors += cd.accept(this);
        }
        return numOfErrors;
    }

    @Override
    public void analyze(Program program) {
        int numOfErrors = this.visit(program);
        if (numOfErrors != 0) System.exit(1);
    }

    @Override
    public Void getResult() {
        return null;
    }
}
