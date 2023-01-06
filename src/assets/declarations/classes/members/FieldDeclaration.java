package assets.declarations.classes.members;

import assets.declarations.TypedVariableDeclaration;
import assets.expressions.Identifier;
import types.Type;
import visitor.Visitor;

public class FieldDeclaration extends TypedVariableDeclaration implements ClassMemberDeclaration {
    private AccessModifier accessModifier;

    public FieldDeclaration(Identifier name) {
        this.identifier = name;
        this.accessModifier = AccessModifier.PRIVATE;
    }

    public FieldDeclaration(Identifier identifier, Type type) {
        this.identifier = identifier;
        this.type = type;
        this.accessModifier = AccessModifier.PRIVATE;
    }

    public FieldDeclaration(Identifier identifier, Type type, AccessModifier modifier) {
        this.identifier = identifier;
        this.type = type;
        this.accessModifier = modifier;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public void setAccessModifier(AccessModifier accessModifier) {
        this.accessModifier = accessModifier;
    }

    @Override
    public String toString() {
        return "FieldDeclaration";
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
