package assets.statement.returned;

import assets.expression.Expression;
import assets.statement.Statement;
import visitor.Visitor;

public class Return extends Statement {
    private Expression returned;

    public Return(Expression returned) {
        this.returned = returned;
    }

    public Expression getReturned() {
        return returned;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "return";
    }
}
