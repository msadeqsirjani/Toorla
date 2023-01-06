package assets.statements;

import assets.expressions.Expression;
import visitor.Visitor;

public class While extends Statement {
    public Expression expression;
    public Statement body;

    public While(Expression expression, Statement body) {
        this.expression = expression;
        this.body = body;
    }

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "While";
    }
}