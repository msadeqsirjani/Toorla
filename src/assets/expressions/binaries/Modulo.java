package assets.expressions.binaries;

import assets.expressions.Expression;
import visitor.Visitor;

public class Modulo extends BinaryExpression {

    public Modulo(Expression left, Expression right) {
        super(left, right);
    }

    public Modulo() {
        super(null, null);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Modulo";
    }
}
