package assets.expressions;

import types.singles.SingleType;
import visitor.Visitor;

public class NewArray extends Expression {
    private Expression length;
    private SingleType type;

    public NewArray(SingleType type, Expression length) {
        this.length = length;
        this.type = type;
    }

    public Expression getLength() {
        return length;
    }

    public SingleType getType() {
        return type;
    }

    public void setType(SingleType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "NewArray";
    }

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
