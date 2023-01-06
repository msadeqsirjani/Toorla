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
import assets.statement.returned.Return;
import name.analyser.comile.error.exception.CompileErrorException;
import visitor.Visitor;

public class ReportingPass implements Visitor<Integer>, INameAnalysingPass<Void> {
    @Override
    public void analyse(Program program) {
        int errors = this.visit(program);
        if (errors != 0) System.exit(1);
    }

    @Override
    public Void getResult() {
        return null;
    }

    @Override
    public Integer visit(And expression) {
        return 0;
    }

    @Override
    public Integer visit(Division expression) {
        return 0;
    }

    @Override
    public Integer visit(Equal expression) {
        return 0;
    }

    @Override
    public Integer visit(GreaterThan expression) {
        return 0;
    }

    @Override
    public Integer visit(LessThan expression) {
        return 0;
    }

    @Override
    public Integer visit(Minus expression) {
        return 0;
    }

    @Override
    public Integer visit(Modulo expression) {
        return 0;
    }

    @Override
    public Integer visit(NotEqual expression) {
        return 0;
    }

    @Override
    public Integer visit(Or expression) {
        return 0;
    }

    @Override
    public Integer visit(Plus expression) {
        return 0;
    }

    @Override
    public Integer visit(Times expression) {
        return 0;
    }

    @Override
    public Integer visit(Negative expression) {
        return 0;
    }

    @Override
    public Integer visit(Not expression) {
        return 0;
    }

    @Override
    public Integer visit(BooleanValue expression) {
        return 0;
    }

    @Override
    public Integer visit(IntegerValue expression) {
        return 0;
    }

    @Override
    public Integer visit(StringValue expression) {
        return 0;
    }

    @Override
    public Integer visit(ArrayCall expression) {
        return 0;
    }

    @Override
    public Integer visit(FieldCall expression) {
        return 0;
    }

    @Override
    public Integer visit(Identifier expression) {
        return 0;
    }

    @Override
    public Integer visit(MethodCall expression) {
        return 0;
    }

    @Override
    public Integer visit(NewArray expression) {
        return 0;
    }

    @Override
    public Integer visit(NewClassInstance expression) {
        return 0;
    }

    @Override
    public Integer visit(Self expression) {
        return 0;
    }

    @Override
    public Integer visit(LocalVariableDef statement) {
        for (CompileErrorException ex : statement.errors) {
            System.out.println(ex);
        }

        return statement.errors.size();
    }

    @Override
    public Integer visit(LocalVariableDefinition statement) {
        int errors = 0;

        for (LocalVariableDef variable : statement.getDefinitions()) {
            errors += variable.accept(this);
        }

        return errors;
    }

    @Override
    public Integer visit(Return statement) {
        return 0;
    }

    @Override
    public Integer visit(Assign statement) {
        return 0;
    }

    @Override
    public Integer visit(Block statement) {
        int errors = 0;

        for (Statement body : statement.getStatements()) {
            errors += body.accept(this);
        }

        return errors;
    }

    @Override
    public Integer visit(Break statement) {
        return 0;
    }

    @Override
    public Integer visit(Conditional statement) {
        return statement.getThen().accept(this) + statement.getTheElse().accept(this);
    }

    @Override
    public Integer visit(Skip statement) {
        return 0;
    }

    @Override
    public Integer visit(Continue statement) {
        return 0;
    }

    @Override
    public Integer visit(Decrement statement) {
        return 0;
    }

    @Override
    public Integer visit(Increment statement) {
        return 0;
    }

    @Override
    public Integer visit(Print statement) {
        return 0;
    }

    @Override
    public Integer visit(While statement) {
        return statement.getBody().accept(this);
    }

    @Override
    public Integer visit(FieldDeclaration declaration) {
        for (CompileErrorException ex : declaration.errors) {
            System.out.println(ex);
        }

        return declaration.errors.size();
    }

    @Override
    public Integer visit(ParameterDeclaration declaration) {
        for (CompileErrorException ex : declaration.errors) {
            System.out.println(ex);
        }

        return declaration.errors.size();
    }

    @Override
    public Integer visit(MethodDeclaration declaration) {
        int errors = declaration.errors.size();

        for (CompileErrorException ex : declaration.errors) {
            System.out.println(ex);
        }

        for (ParameterDeclaration parameter : declaration.getArguments()) {
            errors += parameter.accept(this);
        }

        for (Statement statement : declaration.getStatements()) {
            errors += statement.accept(this);
        }

        return errors;
    }

    @Override
    public Integer visit(ClassDeclaration declaration) {
        int errors = declaration.errors.size();

        for (CompileErrorException ex : declaration.errors) {
            System.out.println(ex);
        }

        for (ClassMemberDeclaration member : declaration.getMembers()) {
            errors += member.accept(this);
        }

        return errors;
    }

    @Override
    public Integer visit(EntryClassDeclaration declaration) {
        return this.visit((ClassDeclaration) declaration);
    }

    @Override
    public Integer visit(Program declaration) {
        int errors = declaration.errors.size();

        for (CompileErrorException ex : declaration.errors) {
            System.out.println(ex);
        }

        for (ClassDeclaration thisClass : declaration.getClasses()) {
            errors += thisClass.accept(this);
        }
        return errors;
    }
}
