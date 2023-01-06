package assets.statement.local.variable;

import assets.expression.Expression;
import assets.expression.Identifier;
import assets.statement.Statement;
import visitor.Visitor;

public class LocalVariableDef extends Statement {
    private Identifier localVariable;
    private Expression initialValue;

    public LocalVariableDef(Identifier localVariable, Expression initialValue) {
        this.localVariable = localVariable;
        this.initialValue = initialValue;
    }

    public Identifier getLocalVariable() {
        return localVariable;
    }

    public Expression getInitialValue() {
        return initialValue;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "local-variable-def";
    }
}
