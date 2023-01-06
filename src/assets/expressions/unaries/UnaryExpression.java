package assets.expressions.unaries;

import assets.expressions.Expression;
import visitor.Visitor;

public abstract class UnaryExpression extends Expression {
    protected Expression expression;

    public UnaryExpression(Expression expression) {
        this.expression = expression;
    }

    public UnaryExpression() {
    }

    public abstract <T> T accept(Visitor<T> visitor);

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}