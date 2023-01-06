package assets.expressions.unaries;

import assets.expressions.Expression;
import visitor.Visitor;

public class Not extends UnaryExpression {

    public Not(Expression expr) {
        super(expr);
    }

    public Not() {
        super(null);
    }

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Not";
    }
}