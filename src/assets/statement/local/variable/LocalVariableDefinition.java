package assets.statement.local.variable;

import assets.statement.Statement;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class LocalVariableDefinition extends Statement {
    private List<LocalVariableDef> definitions;

    public LocalVariableDefinition() {
        definitions = new ArrayList<>();
    }

    public void addVariableDefinition(LocalVariableDef definition) {
        definitions.add(definition);
    }

    public List<LocalVariableDef> getDefinitions() {
        return definitions;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "local-variable-definition-container";
    }
}
