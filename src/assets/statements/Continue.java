package assets.statements;

import visitor.Visitor;

public class Continue extends Statement {

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "(Continue)";
    }
}