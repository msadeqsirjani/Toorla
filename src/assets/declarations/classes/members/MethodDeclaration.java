package assets.declarations.classes.members;

import assets.declarations.Declaration;
import assets.declarations.variables.ParameterDeclaration;
import assets.expressions.Identifier;
import assets.statements.Statement;
import types.Type;
import visitor.Visitor;

import java.util.ArrayList;

public class MethodDeclaration extends Declaration implements ClassMemberDeclaration {
    private Type returnType;
    private Identifier name;
    private AccessModifier accessModifier;
    private ArrayList<ParameterDeclaration> arguments = new ArrayList<>();
    private ArrayList<Statement> body = new ArrayList<>();

    public MethodDeclaration(Identifier name) {
        this.name = name;
        this.accessModifier = AccessModifier.PUBLIC;
    }

    public Type getReturnType() {
        return returnType;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }

    public void setAccessModifier(AccessModifier modifier) {
        this.accessModifier = modifier;
    }

    public AccessModifier getAccessModifier() {
        return this.accessModifier;
    }

    public Identifier getName() {
        return name;
    }

    public ArrayList<ParameterDeclaration> getArguments() {
        return arguments;
    }

    public void addArgument(ParameterDeclaration arg) {
        this.arguments.add(arg);
    }

    public ArrayList<Statement> getBody() {
        return body;
    }

    public void addStatement(Statement statement) {
        this.body.add(statement);
    }

    @Override
    public String toString() {
        return "MethodDeclaration";
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
