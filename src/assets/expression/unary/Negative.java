package assets.expression.unary;

import assets.expression.Expression;
import visitor.Visitor;

public class Negative extends UnaryExpression {
    public Negative(Expression expression) {
        super(expression);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "negative";
    }
}
