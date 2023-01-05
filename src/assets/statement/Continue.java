package assets.statement;

import visitor.Visitor;

public class Continue extends Statement {
    @Override
    public <T> T visit(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "(continue)";
    }
}
