package assets.declaration.description.member;

import assets.declaration.Declaration;
import assets.declaration.description.member.AccessModifier;
import assets.declaration.description.member.ClassMemberDeclaration;
import assets.declaration.local.variable.ParameterDeclaration;
import assets.expression.Identifier;
import assets.statement.Statement;
import types.Type;
import visitor.Visitor;

import java.util.ArrayList;

public class MethodDeclaration extends Declaration implements ClassMemberDeclaration {
    private Type returnedType;
    private Identifier name;
    private AccessModifier accessModifier;
    private ArrayList<ParameterDeclaration> arguments;
    private ArrayList<Statement> statements;

    public MethodDeclaration() {
        arguments = new ArrayList<>();
        statements = new ArrayList<>();
    }

    public MethodDeclaration(Identifier name) {
        this();
        this.name = name;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "method-declaration";
    }

    public Type getReturnedType() {
        return returnedType;
    }

    public void setReturnedType(Type returnedType) {
        this.returnedType = returnedType;
    }

    public Identifier getName() {
        return name;
    }

    public void setName(Identifier name) {
        this.name = name;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public void setAccessModifier(AccessModifier accessModifier) {
        this.accessModifier = accessModifier;
    }

    public ArrayList<ParameterDeclaration> getArguments() {
        return arguments;
    }

    public void addArgument(ParameterDeclaration argument) {
        this.arguments.add(argument);
    }

    public ArrayList<Statement> getStatements() {
        return statements;
    }

    public void addStatement(Statement statement) {
        this.statements.add(statement);
    }
}
