package assets.statement;

import assets.expression.Expression;
import visitor.Visitor;

public class Decrement extends Statement {
    private Expression operand;

    public Decrement(Expression operand) {
        this.operand = operand;
    }

    public Expression getOperand() {
        return operand;
    }

    @Override
    public <T> T visit(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "(decrement)";
    }
}

