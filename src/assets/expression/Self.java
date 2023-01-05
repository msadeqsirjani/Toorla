package assets.expression;

import visitor.Visitor;

public class Self extends Expression {
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "(Self)";
    }
}
