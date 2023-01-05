package assets.statement;

import assets.expression.Expression;
import visitor.Visitor;

public class While extends Statement {
    private Expression expression;
    private Statement body;

    public While(Expression expression, Statement body) {
        this.expression = expression;
        this.body = body;
    }

    public Expression getExpression() {
        return expression;
    }

    public Statement getBody() {
        return body;
    }

    @Override
    public <T> T visit(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "while";
    }
}
