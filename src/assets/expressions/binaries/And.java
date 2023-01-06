package assets.expressions.binaries;


import assets.expressions.Expression;
import visitor.Visitor;

public class And extends BinaryExpression {
    public And(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "And";
    }
}
