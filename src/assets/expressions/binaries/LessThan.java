package assets.expressions.binaries;

import assets.expressions.Expression;
import visitor.Visitor;

public class LessThan extends BinaryExpression {

    public LessThan(Expression left, Expression right) {
        super(left, right);
    }

    public LessThan() {
        super(null, null);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "LessThan";
    }
}
