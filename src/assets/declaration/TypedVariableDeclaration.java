package assets.declaration;

import assets.expression.Identifier;
import types.Type;

public abstract class TypedVariableDeclaration extends VariableDeclaration {
    protected Type type;

    public TypedVariableDeclaration(Identifier identifier) {
        super(identifier);
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
