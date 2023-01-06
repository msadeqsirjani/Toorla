package assets.statements;

import assets.expressions.Expression;
import visitor.Visitor;

public class Assign extends Statement {
    private Expression left;
    private Expression right;

    public Assign(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Expression getRight() {
        return right;
    }


    public Expression getLeft() {
        return left;
    }

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Assign";
    }
}