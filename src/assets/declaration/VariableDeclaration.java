package assets.declaration;

import assets.expression.Identifier;

public abstract class VariableDeclaration extends Declaration {
    protected Identifier identifier;

    public VariableDeclaration(Identifier identifier) {
        this.identifier = identifier;
    }

    public Identifier getIdentifier() {
        return this.identifier;
    }
}
