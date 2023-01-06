package assets.expressions;

import visitor.Visitor;

public class NewClassInstance extends Expression {
    private Identifier className;

    public NewClassInstance(Identifier className) {
        this.className = className;
    }

    public Identifier getClassName() {
        return className;
    }


    @Override
    public String toString() {
        return "NewClass";
    }

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
