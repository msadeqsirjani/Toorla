package assets.expressions.binaries;

import assets.expressions.Expression;
import visitor.Visitor;

public class Or extends BinaryExpression {

    public Or(Expression left, Expression right) {
        super(left, right);
    }

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Or";
    }
}