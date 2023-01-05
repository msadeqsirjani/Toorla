package symbol.table.items.variables;

import symbol.table.items.SymbolTableItem;
import types.Type;

public class VariableSymbolTableItem extends SymbolTableItem {
    protected Type variableType;

    public static String variableModifier = "var_";

    @Override
    public String getKey() {
        return VariableSymbolTableItem.variableModifier + name;
    }

    public Type getVariableType() {
        return variableType;
    }

    public void setVariableType(Type variableType) {
        this.variableType = variableType;
    }
}
