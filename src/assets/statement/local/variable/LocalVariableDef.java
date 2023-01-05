package assets.statement.local.variable;

import assets.expression.Expression;
import assets.statement.Statement;
import visitor.Visitor;

public class LocalVariableDef extends Statement {
    private Expression localVariable;
    private Expression initialValue;

    public LocalVariableDef(Expression localVariable, Expression initialValue) {
        this.localVariable = localVariable;
        this.initialValue = initialValue;
    }

    public Expression getLocalVariable() {
        return localVariable;
    }

    public Expression getInitialValue() {
        return initialValue;
    }

    @Override
    public <T> T visit(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "local-variable-def";
    }
}
