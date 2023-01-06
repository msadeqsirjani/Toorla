package visitor;

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
import symbol.table.items.SymbolTableItem;

import java.util.ArrayList;

public class TreePrinter implements Visitor<Void> {
    ArrayList<Error> errors = new ArrayList<Error>();
    SymbolTable programSymTable;
    Program program;
    SymbolTableItem currentSymItem = null;
    ClassDeclaration currenClassDeclaration = null;

    @Override
    public Void visit(Print print) {
        System.out.print("(print ");
        print.getArg().accept(this);
        System.out.println(")");
        return null;
    }

    @Override
    public Void visit(Assign assign) {
        System.out.print("(= ");
        assign.getLeft().accept(this);
        System.out.print(" ");
        assign.getRight().accept(this);
        System.out.println(")");
        return null;
    }

    @Override
    public Void visit(Block block) {
        System.out.println("( ");
        for (Statement s : block.body)
            s.accept(this);
        System.out.println(")");
        return null;
    }

    @Override
    public Void visit(Conditional conditional) {
        System.out.print("(if ");
        conditional.getCondition().accept(this);
        System.out.print(" ");
        conditional.getThenStatement().accept(this);
        System.out.print(" ");
        conditional.getElseStatement().accept(this);
        System.out.println(")");
        return null;
    }

    @Override
    public Void visit(While whileStat) {
        System.out.print("(while ");
        whileStat.expression.accept(this);
        System.out.print(" ");
        whileStat.body.accept(this);
        System.out.println(")");
        return null;
    }

    @Override
    public Void visit(Return returnStat) {
        System.out.print("(return ");
        returnStat.getReturnedExpr().accept(this);
        System.out.println(")");
        return null;
    }

    @Override
    public Void visit(Plus plusExpr) {
        System.out.print("(+ ");
        plusExpr.getLeft().accept(this);
        System.out.print(" ");
        plusExpr.getRight().accept(this);
        System.out.print(")");
        return null;
    }

    @Override
    public Void visit(Minus minusExpr) {
        System.out.print("(- ");
        minusExpr.getLeft().accept(this);
        System.out.print(" ");
        minusExpr.getRight().accept(this);
        System.out.print(")");
        return null;
    }

    @Override
    public Void visit(Times timesExpr) {
        System.out.print("(* ");
        timesExpr.getLeft().accept(this);
        System.out.print(" ");
        timesExpr.getRight().accept(this);
        System.out.print(")");
        return null;
    }

    @Override
    public Void visit(Division divisionExpr) {
        System.out.print("(/ ");
        divisionExpr.getLeft().accept(this);
        System.out.print(" ");
        divisionExpr.getRight().accept(this);
        System.out.print(")");
        return null;
    }

    @Override
    public Void visit(Modulo moduloExpr) {
        System.out.print("(% ");
        moduloExpr.getLeft().accept(this);
        System.out.print(" ");
        moduloExpr.getRight().accept(this);
        System.out.print(")");
        return null;
    }

    @Override
    public Void visit(Equals equalsExpr) {
        System.out.print("(== ");
        equalsExpr.getLeft().accept(this);
        System.out.print(" ");
        equalsExpr.getRight().accept(this);
        System.out.print(")");
        return null;
    }

    @Override
    public Void visit(GreaterThan gtExpr) {
        System.out.print("(> ");
        gtExpr.getLeft().accept(this);
        System.out.print(" ");
        gtExpr.getRight().accept(this);
        System.out.print(")");
        return null;
    }

    @Override
    public Void visit(LessThan ltExpr) {
        System.out.print("(< ");
        ltExpr.getLeft().accept(this);
        System.out.print(" ");
        ltExpr.getRight().accept(this);
        System.out.print(")");
        return null;
    }

    @Override
    public Void visit(And andExpr) {
        System.out.print("(&& ");
        andExpr.getLeft().accept(this);
        System.out.print(" ");
        andExpr.getRight().accept(this);
        System.out.print(")");
        return null;
    }

    @Override
    public Void visit(Or orExpr) {
        System.out.print("(|| ");
        orExpr.getLeft().accept(this);
        System.out.print(" ");
        orExpr.getRight().accept(this);
        System.out.print(")");
        return null;
    }

    @Override
    public Void visit(Negative negativeExpr) {
        System.out.print("(- ");
        negativeExpr.getExpression().accept(this);
        System.out.print(")");
        return null;
    }

    @Override
    public Void visit(Not notExpr) {
        System.out.print("(! ");
        notExpr.getExpression().accept(this);
        System.out.print(")");
        return null;
    }

    @Override
    public Void visit(MethodCall methodCall) {
        System.out.print("(. ");
        methodCall.getInstance().accept(this);
        System.out.print(" ");
        methodCall.getMethodName().accept(this);
        System.out.print(" (");
        for (Expression arg : methodCall.getArgs()) {
            arg.accept(this);
            System.out.print(" ");
        }
        System.out.print(") ");
        System.out.print(")");
        return null;
    }

    @Override
    public Void visit(Identifier identifier) {
        System.out.print(identifier);
        return null;
    }

    @Override
    public Void visit(Self self) {
        System.out.print(self);
        return null;
    }

    @Override
    public Void visit(Break breakStat) {
        System.out.println(breakStat);
        return null;
    }

    @Override
    public Void visit(Continue continueStat) {
        System.out.println(continueStat);
        return null;
    }

    @Override
    public Void visit(Skip skip) {
        System.out.println(skip);
        return null;
    }

    @Override
    public Void visit(IntValue intValue) {
        System.out.print(intValue);
        return null;
    }

    @Override
    public Void visit(NewArray newArray) {
        System.out.print("(new arrayof ");
        System.out.print(newArray.getType());
        System.out.print(" ");
        newArray.getLength().accept(this);
        System.out.print(")");
        return null;
    }

    @Override
    public Void visit(BoolValue booleanValue) {
        System.out.print(booleanValue);
        return null;
    }

    @Override
    public Void visit(StringValue stringValue) {
        System.out.print(stringValue);
        return null;
    }

    @Override
    public Void visit(NewClassInstance newClassInstance) {
        System.out.print("(new ");
        newClassInstance.getClassName().accept(this);
        System.out.print(")");
        return null;
    }

    @Override
    public Void visit(FieldCall fieldCall) {
        System.out.print("(. ");
        fieldCall.getInstance().accept(this);
        System.out.print(" ");
        fieldCall.getField().accept(this);
        System.out.print(")");
        return null;
    }

    @Override
    public Void visit(ArrayCall arrayCall) {
        System.out.print("([] ");
        arrayCall.getInstance().accept(this);
        System.out.print(" ");
        arrayCall.getIndex().accept(this);
        System.out.print(")");
        return null;
    }

    @Override
    public Void visit(NotEquals notEquals) {
        System.out.print("(<> ");
        notEquals.getLeft().accept(this);
        System.out.print(" ");
        notEquals.getRight().accept(this);
        System.out.print(")");
        return null;
    }

    @Override
    public Void visit(LocalVariableDef localVariableDef) {
        System.out.print("(var ");
        localVariableDef.getLocalVarName().accept(this);
        System.out.print(" ");
        localVariableDef.getInitialValue().accept(this);
        System.out.println(")");
        return null;
    }

    @Override
    public Void visit(Increment increment) {
        System.out.print("(++ ");
        increment.getOperand().accept(this);
        System.out.println(")");
        return null;
    }

    @Override
    public Void visit(Decrement decrement) {
        System.out.print("(-- ");
        decrement.getOperand().accept(this);
        System.out.println(")");
        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        System.out.print("(class ");
        printClassBody(classDeclaration);
        return null;
    }

    private void printClassBody(ClassDeclaration classDeclaration) {
        classDeclaration.getName().accept(this);
        System.out.print(" ");
        if (classDeclaration.getParentName().getName() != null) {
            classDeclaration.getParentName().accept(this);
            System.out.print(" ");
        }
        for (ClassMemberDeclaration md : classDeclaration.getClassMembers())
            md.accept(this);
        System.out.println(")");
    }

    @Override
    public Void visit(EntryClassDeclaration entryClassDeclaration) {
        System.out.print("( entry class ");
        printClassBody(entryClassDeclaration);
        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDeclaration) {
        System.out.print("(");
        System.out.print(fieldDeclaration.getAccessModifier());
        System.out.print(" field ");
        fieldDeclaration.getIdentifier().accept(this);
        System.out.print(" ");
        System.out.print(fieldDeclaration.getType());
        System.out.println(")");
        return null;
    }

    @Override
    public Void visit(ParameterDeclaration parameterDeclaration) {
        System.out.print("( ");
        parameterDeclaration.getIdentifier().accept(this);
        System.out.print(" : ");
        System.out.print(parameterDeclaration.getType());
        System.out.print(")");
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        System.out.print("(");
        System.out.print(methodDeclaration.getAccessModifier());
        System.out.print(" method ");
        methodDeclaration.getName().accept(this);
        for (ParameterDeclaration pd : methodDeclaration.getArguments()) {
            pd.accept(this);
            System.out.print(" ");
        }
        System.out.print(methodDeclaration.getReturnType());
        System.out.println(" (");
        for (Statement stmt : methodDeclaration.getBody())
            stmt.accept(this);
        System.out.println(" ) ");
        System.out.println(")");
        return null;
    }

    @Override
    public Void visit(LocalVariableDefinitions localVariableDefinitions) {
        for (LocalVariableDef lvd : localVariableDefinitions.getVarDefinitions())
            lvd.accept(this);
        return null;
    }

    @Override
    public Void visit(Program program) {
        System.out.print("(");
        for (ClassDeclaration cd : program.getClasses())
            cd.accept(this);
        System.out.println(")");
        return null;
    }
}