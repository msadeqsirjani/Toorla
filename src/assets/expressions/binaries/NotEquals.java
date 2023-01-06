package assets.expressions.binaries;

import assets.expressions.Expression;
import visitor.Visitor;

public class NotEquals extends BinaryExpression {

    public NotEquals(Expression left, Expression right) {
        super(left, right);
    }

    public NotEquals() {
        super(null, null);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "NotEquals";
    }
}
