package assets.expressions.value;

import assets.expressions.Expression;
import types.Type;
import visitor.Visitor;

public abstract class Value extends Expression {
    abstract public Type getType();


    protected Type type;

    public abstract String toString();


    public abstract <T> T accept(Visitor<T> visitor);
}