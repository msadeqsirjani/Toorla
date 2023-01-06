package assets.statements.variables;

import assets.statements.Statement;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class LocalVariableDefinitions extends Statement {
    private List<LocalVariableDef> definitions;

    public LocalVariableDefinitions() {
        definitions = new ArrayList<>();
    }

    public void addVarDefinition(LocalVariableDef localVariableDefinition) {
        definitions.add(localVariableDefinition);
    }

    public List<LocalVariableDef> getVarDefinitions() {
        return definitions;
    }

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "local-variable-definition";
    }
}