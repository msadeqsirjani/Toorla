package assets.statements.variables;

import assets.expressions.Expression;
import assets.expressions.Identifier;
import assets.statements.Statement;
import visitor.Visitor;

public class LocalVariableDef extends Statement {
    private Identifier localVarName;
    private Expression initialValue;

    public LocalVariableDef(Identifier localVarName, Expression initialValue) {
        this.localVarName = localVarName;
        this.initialValue = initialValue;
    }

    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "local-variable-def";
    }

    public Expression getInitialValue() {
        return initialValue;
    }


    public Identifier getLocalVarName() {
        return localVarName;
    }

}
