package assets.expressions;

import visitor.Visitor;

public class Self extends Expression {
    @Override
    public String toString() {
        return "(Self)";
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
