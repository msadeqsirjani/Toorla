package assets.expressions.unaries;

import assets.expressions.Expression;
import visitor.Visitor;

public class Negative extends UnaryExpression {

    public Negative(Expression expr) {
        super(expr);
    }

    public Negative() {
        super(null);
    }

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Negative";
    }
}
