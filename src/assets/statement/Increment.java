package assets.statement;

import assets.expression.Expression;
import visitor.Visitor;

public class Increment extends Statement {
    private Expression operand;

    public Increment(Expression operand) {
        this.operand = operand;
    }

    public Expression getOperand() {
        return operand;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "(increment)";
    }
}
