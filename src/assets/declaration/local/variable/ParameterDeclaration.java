package assets.declaration.local.variable;

import assets.declaration.TypedVariableDeclaration;
import assets.expression.Identifier;
import types.Type;
import visitor.Visitor;

public class ParameterDeclaration extends TypedVariableDeclaration {
    public ParameterDeclaration(Identifier identifier, Type type) {
        super(identifier);
        this.type = type;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "parameter";
    }
}
