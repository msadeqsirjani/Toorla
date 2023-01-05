package assets.expression.value;

import types.Type;
import types.single.IntegerType;
import visitor.Visitor;

public class IntegerValue extends Value {
    private int constant;

    public IntegerValue(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }

    public void setConstant(int constant) {
        this.constant = constant;
    }

    @Override
    public Type getType() {
        return new IntegerType();
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "(Integer, " + constant + ")";
    }
}
