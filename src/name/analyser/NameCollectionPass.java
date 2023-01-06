package name.analyser;

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
import name.analyser.comile.error.exception.*;
import symbol.table.SymbolTable;
import symbol.table.exceptions.*;
import symbol.table.items.*;
import symbol.table.items.variables.*;
import types.Type;
import visitor.Visitor;

import java.util.ArrayList;

public class NameCollectionPass implements Visitor<Void>, INameAnalysingPass<Void> {
    private int localVariableIndex = 0;
    private int counter = 0;

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
        var variableName = statement.getLocalVariable().getName();

        try {
            SymbolTable.top().put(new LocalVariableSymbolTableItem(variableName, localVariableIndex));
        } catch (ItemAlreadyExistsException ex) {
            var exception = new LocalVariableRedefinitionException(variableName, statement.line, statement.column);
            statement.errors.add(exception);
        }

        localVariableIndex++;

        return null;
    }

    @Override
    public Void visit(LocalVariableDefinition statement) {
        for (var definition : statement.getDefinitions()) {
            definition.accept(this);
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
        SymbolTable.push(new SymbolTable(SymbolTable.top()));

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
        SymbolTable.push(new SymbolTable(SymbolTable.top()));

        statement.getThen().accept(this);

        SymbolTable.pop();
        SymbolTable.push(new SymbolTable(SymbolTable.top()));

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
        SymbolTable.push(new SymbolTable(SymbolTable.top()));
        statement.getBody().accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(FieldDeclaration declaration) {
        if (!declaration.getIdentifier().getName().equals("length")) {
            try {
                SymbolTable.top().put(new FieldSymbolTableItem(declaration.getIdentifier().getName(), declaration.getAccessModifier(), declaration.getType()));
            } catch (ItemAlreadyExistsException ex) {
                var exception = new FieldRedefinitionException(declaration.getIdentifier().getName(), declaration.line, declaration.column);
                declaration.errors.add(exception);
            }
        } else {
            var e = new FieldNamedLengthDeclarationException(declaration.getIdentifier().line, declaration.getIdentifier().column);

            declaration.errors.add(e);
        }

        return null;
    }

    @Override
    public Void visit(ParameterDeclaration declaration) {
        try {
            SymbolTable.top().put(new LocalVariableSymbolTableItem(declaration.getIdentifier().getName(), localVariableIndex));
        } catch (ItemAlreadyExistsException ex) {
            var exception = new LocalVariableRedefinitionException(declaration.getIdentifier().getName(), declaration.line, declaration.column);

            declaration.errors.add(exception);
        }

        localVariableIndex++;

        return null;
    }

    @Override
    public Void visit(MethodDeclaration declaration) {
        localVariableIndex = 1;
        try {
            var argumentsTypes = new ArrayList<Type>();
            for (ParameterDeclaration arg : declaration.getArguments()) {
                argumentsTypes.add(arg.getType());
            }

            SymbolTable.top().put(new MethodSymbolTableItem(declaration.getName().getName(), declaration.getReturnedType(), argumentsTypes, declaration.getAccessModifier()));
        } catch (ItemAlreadyExistsException ex) {
            var exception = new MethodRedefinitionException(declaration.getName().getName(), declaration.getName().line, declaration.getName().column);
            declaration.errors.add(exception);
        }

        SymbolTable.push(new SymbolTable(SymbolTable.top()));

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
        counter++;
        var thisClass = new ClassSymbolTableItem(declaration.getName().getName());
        SymbolTable.push(new SymbolTable(SymbolTable.top()));

        try {
            thisClass.setTable(SymbolTable.top());
            thisClass.setParent(SymbolTable.top().getTable());
            SymbolTable.root.put(thisClass);
        } catch (ItemAlreadyExistsException ex) {
            var exception = new ClassRedefinitionException(declaration, counter);
            exception.handle();
            declaration.errors.add(exception);
        }

        for (ClassMemberDeclaration member : declaration.getMembers()) {
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
        for (ClassDeclaration thisClass : declaration.getClasses()) {
            thisClass.accept(this);
        }

        SymbolTable.pop();

        return null;
    }
}
