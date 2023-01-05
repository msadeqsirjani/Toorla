package assets.expression;

import visitor.Visitor;

public class ArrayCall extends Expression {
    private Expression instance;
    private Expression index;

    public ArrayCall(Expression instance, Expression index) {
        this.instance = instance;
        this.index = index;
    }

    public Expression getInstance() {
        return instance;
    }

    public Expression getIndex() {
        return index;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "array-call";
    }
}
