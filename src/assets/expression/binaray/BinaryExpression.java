package assets.expression.binaray;

import assets.expression.Expression;
import visitor.Visitor;

public abstract class BinaryExpression extends Expression {
    protected Expression lhs;
    protected Expression rhs;

    public BinaryExpression(Expression lhs, Expression rhs){
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public Expression getLhs() {
        return lhs;
    }

    public void setLhs(Expression lhs) {
        this.lhs = lhs;
    }

    public Expression getRhs() {
        return rhs;
    }

    public void setRhs(Expression rhs) {
            this.rhs = rhs;
    }

    public abstract <T> T accept(Visitor<T> visitor);
}
