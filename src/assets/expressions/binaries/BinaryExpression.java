package assets.expressions.binaries;

import assets.expressions.Expression;
import visitor.Visitor;

public abstract class BinaryExpression extends Expression {
    protected Expression left;
    protected Expression right;

    public BinaryExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public BinaryExpression() {
    }

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    public void setSides(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public abstract <T> T accept(Visitor<T> visitor);

}