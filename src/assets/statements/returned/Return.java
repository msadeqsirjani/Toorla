package assets.statements.returned;

import assets.expressions.Expression;
import assets.statements.Statement;
import visitor.Visitor;

public class Return extends Statement {
    private Expression returnedExpr;

    public Return(Expression returnedExpr) {
        this.returnedExpr = returnedExpr;
    }

    public Expression getReturnedExpr() {
        return returnedExpr;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Return";
    }
}
