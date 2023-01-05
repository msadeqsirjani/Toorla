package assets.expression;

import types.single.SingleType;
import visitor.Visitor;

public class NewArray extends Expression {
    private Expression length;
    private SingleType type;

    public NewArray(Expression length, SingleType type) {
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
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "new-array";
    }
}
