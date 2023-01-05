package assets.statement;

import assets.expression.Expression;
import visitor.Visitor;

public class Conditional extends Statement {
    private Expression condition;
    private Statement then;
    private Statement theElse;

    public Conditional(Expression condition, Statement then) {
        this.condition = condition;
        this.then = then;
        this.theElse = new Skip();
    }

    public Conditional(Expression condition, Statement then, Statement theElse) {
        this.condition = condition;
        this.then = then;
        this.theElse = theElse;
    }

    public Expression getCondition() {
        return condition;
    }

    public Statement getThen() {
        return then;
    }

    public Statement getTheElse() {
        return theElse;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "(conditional)";
    }
}
