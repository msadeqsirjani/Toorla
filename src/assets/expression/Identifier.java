package assets.expression;

import visitor.Visitor;

public class Identifier extends Expression {
    private String name;

    public Identifier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return this.name != "" ? "(Identifier, " + this.name + ")" : "(Identifier, Empty)";
    }
}
