package assets.declarations.variables;

import assets.declarations.TypedVariableDeclaration;
import assets.expressions.Identifier;
import types.Type;
import visitor.Visitor;

public class ParameterDeclaration extends TypedVariableDeclaration {
    public ParameterDeclaration(Identifier name, Type type) {
        this.identifier = name;
        this.type = type;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Parameter";
    }
}