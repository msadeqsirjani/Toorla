package assets.expression;

import visitor.Visitor;

public class NewClassInstance extends Expression {
    private Identifier theClass;

    public NewClassInstance(Identifier theClass) {
        this.theClass = theClass;
    }

    public Identifier getTheClass() {
        return theClass;
    }

    @Override
    public <T> T visit(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "new-class";
    }
}
