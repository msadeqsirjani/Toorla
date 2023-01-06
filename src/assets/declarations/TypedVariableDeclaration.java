package assets.declarations;

import types.Type;

public abstract class TypedVariableDeclaration extends VariableDeclaration {
    protected Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}