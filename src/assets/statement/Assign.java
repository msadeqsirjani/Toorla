package assets.statement;

import assets.expression.Expression;
import visitor.Visitor;

public class Assign extends Expression {
    private Expression left;
    private Expression right;

    public Assign(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "assign";
    }
}
