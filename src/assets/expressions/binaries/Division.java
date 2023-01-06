package assets.expressions.binaries;

import assets.expressions.Expression;
import visitor.Visitor;

public class Division extends BinaryExpression {

    public Division(Expression left, Expression right) {
        super(left, right);
    }

    public Division() {
        super(null, null);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Division";
    }
}
