package assets.expressions.binaries;

import assets.expressions.Expression;
import visitor.Visitor;

public class Times extends BinaryExpression {

    public Times(Expression left, Expression right) {
        super(left, right);
    }

    public Times() {
        super(null, null);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Times";
    }
}
