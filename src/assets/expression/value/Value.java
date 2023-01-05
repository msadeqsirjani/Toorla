package assets.expression.value;

import assets.expression.Expression;
import types.Type;
import visitor.Visitor;

public abstract class Value extends Expression {
    protected Type type;

    public abstract Type getType();
    public abstract <T> T accept(Visitor<T> visitor);
    public abstract String toString();
}
