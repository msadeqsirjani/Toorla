package name.analyser;

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
import name.analyser.comile.error.exception.FieldRedefinitionException;
import name.analyser.comile.error.exception.MethodRedefinitionException;
import symbol.table.SymbolTable;
import symbol.table.exceptions.ItemNotFoundException;
import symbol.table.items.MethodSymbolTableItem;
import symbol.table.items.variables.VariableSymbolTableItem;
import visitor.Visitor;

public class NameCheckingPass implements Visitor<Void>, INameAnalysingPass<Void> {
    @Override
    public void analyse(Program program) {
        this.visit(program);
    }

    @Override
    public Void getResult() {
        return null;
    }

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
        for (var variable : statement.getDefinitions()) {
            variable.accept(this);
        }

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
        SymbolTable.pushFromQueue();

        for (Statement body : statement.getStatements()) {
            body.accept(this);
        }

        SymbolTable.pop();

        return null;
    }

    @Override
    public Void visit(Break statement) {
        return null;
    }

    @Override
    public Void visit(Conditional statement) {
        SymbolTable.pushFromQueue();

        statement.getTheElse().accept(this);

        SymbolTable.pop();
        SymbolTable.pushFromQueue();

        statement.getTheElse().accept(this);

        SymbolTable.pop();

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
        SymbolTable.pushFromQueue();

        statement.getBody().accept(this);

        SymbolTable.pop();

        return null;
    }

    @Override
    public Void visit(FieldDeclaration declaration) {
        if (declaration.errors.size() == 0) {
            try {
                var sameFieldInParents = SymbolTable.top().getInParentScope(VariableSymbolTableItem.variableModifier + declaration.getIdentifier().getName());
                var e = new FieldRedefinitionException(declaration.getIdentifier().getName(), declaration.line, declaration.column);
                declaration.errors.add(e);
            } catch (ItemNotFoundException ignored) {
            }
        }
        return null;
    }

    @Override
    public Void visit(ParameterDeclaration declaration) {
        return null;
    }

    @Override
    public Void visit(MethodDeclaration declaration) {
        if (declaration.errors.size() == 0) try {
            var sameMethodInParents = SymbolTable.top().getInParentScope(MethodSymbolTableItem.methodModifier + declaration.getName().getName());
            var exception = new MethodRedefinitionException(declaration.getName().getName(), declaration.getName().line, declaration.getName().column);
            declaration.errors.add(exception);
        } catch (ItemNotFoundException ignored) {
        }

        SymbolTable.pushFromQueue();

        for (ParameterDeclaration parameter : declaration.getArguments()) {
            parameter.accept(this);
        }

        for (Statement statement : declaration.getStatements()) {
            statement.accept(this);
        }

        SymbolTable.pop();

        return null;
    }

    @Override
    public Void visit(ClassDeclaration declaration) {
        SymbolTable.pushFromQueue();

        for (var member : declaration.getMembers()) {
            member.accept(this);
        }

        SymbolTable.pop();

        return null;
    }

    @Override
    public Void visit(EntryClassDeclaration declaration) {
        this.visit((ClassDeclaration) declaration);

        return null;
    }

    @Override
    public Void visit(Program declaration) {
        SymbolTable.pushFromQueue();

        for (ClassDeclaration thisClass : declaration.getClasses()) {
            thisClass.accept(this);
        }

        SymbolTable.pop();

        return null;
    }
}
