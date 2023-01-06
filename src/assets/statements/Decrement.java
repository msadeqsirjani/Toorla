package assets.statements;

import assets.expressions.Expression;
import visitor.Visitor;

public class Decrement extends Statement {
    private Expression operand;

    public Decrement(Expression operand) {
        this.operand = operand;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Decrement";
    }

    public Expression getOperand() {
        return operand;
    }

}
