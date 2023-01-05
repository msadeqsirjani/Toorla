package assets.expression.binaray;

import assets.expression.Expression;
import visitor.Visitor;

public class Modulo extends BinaryExpression {
    public Modulo(Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "modulo";
    }
}
