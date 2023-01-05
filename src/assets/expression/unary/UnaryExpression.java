package assets.expression.unary;

import assets.expression.Expression;
import visitor.Visitor;

public abstract class UnaryExpression extends Expression {
    protected Expression expression;

    public UnaryExpression(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return this.expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public abstract <T> T accept(Visitor<T> visitor);
}
