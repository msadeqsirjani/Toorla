package assets.statements;

import assets.expressions.Expression;
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

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expression getCondition() {
        return condition;
    }

    public Statement getThenStatement() {
        return then;
    }

    public Statement getElseStatement() {
        return theElse;
    }

    @Override
    public String toString() {
        return "Conditional";
    }
}