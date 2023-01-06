package assets.expressions.binaries;

import assets.expressions.Expression;
import visitor.Visitor;

public class Equals extends BinaryExpression {

    public Equals(Expression left, Expression right) {
        super(left, right);
    }

    public Equals() {
        super(null, null);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Equals";
    }
}
