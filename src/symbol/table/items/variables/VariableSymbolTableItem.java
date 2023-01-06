package symbol.table.items.variables;

import symbol.table.items.SymbolTableItem;
import types.Type;

public class VariableSymbolTableItem extends SymbolTableItem {
    protected Type varType;

    public static String var_modifier = "var_";

    public String getKey() {
        return VariableSymbolTableItem.var_modifier + name;
    }

    public Type getVarType() {
        return varType;
    }

    public void setVarType(Type varType) {
        this.varType = varType;
    }
}
