package assets.declaration.description.member;

import assets.declaration.TypedVariableDeclaration;
import assets.declaration.description.member.AccessModifier;
import assets.declaration.description.member.ClassMemberDeclaration;
import assets.expression.Identifier;
import types.Type;
import visitor.Visitor;

public class FieldDeclaration extends TypedVariableDeclaration implements ClassMemberDeclaration {
    private AccessModifier accessModifier;

    public FieldDeclaration(Identifier identifier) {
        super(identifier);
        this.accessModifier = AccessModifier.PRIVATE;
    }

    public FieldDeclaration(Identifier identifier, Type type){
        super(identifier);
        this.type = type;
        this.accessModifier = AccessModifier.PRIVATE;
    }

    public FieldDeclaration(Identifier identifier, Type type, AccessModifier accessModifier){
        super(identifier);
        this.type = type;
        this.accessModifier = accessModifier;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public void setAccessModifier(AccessModifier accessModifier) {
        this.accessModifier = accessModifier;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "field-declaration";
    }
}
