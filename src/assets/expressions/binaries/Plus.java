package assets.expressions.binaries;

import assets.expressions.Expression;
import visitor.Visitor;

public class Plus extends BinaryExpression {

    public Plus(Expression left, Expression right) {
        super(left, right);
    }

    public Plus() {
        super(null, null);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Plus";
    }
}