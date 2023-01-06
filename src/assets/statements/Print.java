package assets.statements;

import assets.expressions.Expression;
import visitor.Visitor;

public class Print extends Statement {
    private Expression arg;

    public Print(Expression arg) {
        this.arg = arg;
    }

    public Expression getArg() {
        return arg;
    }


    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Print";
    }
}