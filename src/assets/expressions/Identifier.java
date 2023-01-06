package assets.expressions;

import visitor.Visitor;

public class Identifier extends Expression {
    private String name;

    public Identifier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        if (name != null)
            return "(Identifier," + name + ")";
        else
            return "(Identifier,Dummy)";
    }
}
