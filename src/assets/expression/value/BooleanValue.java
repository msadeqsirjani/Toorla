package assets.expression.value;

import types.Type;
import types.single.BooleanType;
import visitor.Visitor;

public class BooleanValue extends Value {
    private boolean constant;

    public BooleanValue(boolean constant) {
        this.constant = constant;
    }

    public boolean isConstant() {
        return constant;
    }

    public void setConstant(boolean constant) {
        this.constant = constant;
    }

    @Override
    public Type getType() {
        return new BooleanType();
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "(Boolean, " + constant + ")";
    }
}
