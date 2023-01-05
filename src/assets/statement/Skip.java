package assets.statement;

import visitor.Visitor;

public class Skip extends Statement {
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "(skip)";
    }
}
