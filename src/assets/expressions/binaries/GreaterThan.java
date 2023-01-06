package assets.expressions.binaries;

import assets.expressions.Expression;
import visitor.Visitor;

public class GreaterThan extends BinaryExpression {

    public GreaterThan(Expression left, Expression right) {
        super(left, right);
    }

    public GreaterThan() {
        super(null, null);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "GreaterThan";
    }
}