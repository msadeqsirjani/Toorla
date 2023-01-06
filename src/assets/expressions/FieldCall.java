package assets.expressions;

import visitor.Visitor;

public class FieldCall extends Expression {
    private Expression instance;
    private Identifier field;
    public FieldCall(Expression instance , Identifier field )
    {
        this.instance = instance;
        this.field = field;
    }

    public Expression getInstance() {
        return instance;
    }


    public Identifier getField() {
        return field;
    }


    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit( this );
    }

    @Override
    public String toString() {
        return "FieldCall";
    }
}
