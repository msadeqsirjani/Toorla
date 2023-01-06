package assets.expressions.binaries;

import assets.expressions.Expression;
import visitor.Visitor;

public class Minus extends BinaryExpression {

    public Minus(Expression left, Expression right) {
        super(left, right);
    }

    public Minus() {
        super(null, null);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Minus";
    }
}
