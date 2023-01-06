package assets.expressions.value;


import types.Type;
import types.singles.BoolType;
import visitor.Visitor;

public class BoolValue extends Value {
    private boolean constant;

    public BoolValue(boolean constant) {
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
        return new BoolType();
    }

    @Override
    public String toString() {
        return "(BoolValue," + constant + ")";
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
