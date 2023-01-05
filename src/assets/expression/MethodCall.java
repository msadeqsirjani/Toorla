package assets.expression;

import visitor.Visitor;

import java.util.ArrayList;

public class MethodCall extends Expression {
    private Expression instance;
    private Identifier method;
    private ArrayList<Expression> arguments;

    public MethodCall(Expression instance, Identifier method) {
        this.instance = instance;
        this.method = method;
        this.arguments = new ArrayList<>();
    }

    public Expression getInstance() {
        return instance;
    }

    public Identifier getMethod() {
        return method;
    }

    public ArrayList<Expression> getArguments() {
        return arguments;
    }

    public void addArgument(Expression expression) {
        this.arguments.add(expression);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "method-call";
    }
}
