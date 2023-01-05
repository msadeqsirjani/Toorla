package assets.expression.binaray;

import assets.expression.Expression;
import visitor.Visitor;

public class Equal extends BinaryExpression {
    public Equal(Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "equal";
    }
}
