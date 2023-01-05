package assets.statement;

import assets.expression.Expression;
import visitor.Visitor;

public class Print extends Statement {
    private Expression argument;

    public Print(Expression argument) {
        this.argument = argument;
    }

    public Expression getArgument() {
        return argument;
    }

    @Override
    public <T> T visit(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "print";
    }
}
