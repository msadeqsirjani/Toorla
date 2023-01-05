package symbol.table.items.variables;

import assets.declaration.description.member.AccessModifier;
import types.Type;

public class FieldSymbolTableItem extends VariableSymbolTableItem {
    private AccessModifier accessModifier;

    public FieldSymbolTableItem(String name, AccessModifier accessModifier, Type variableType) {
        this.name = name;
        this.variableType = variableType;
        this.accessModifier = accessModifier;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public void setAccessModifier(AccessModifier accessModifier) {
        this.accessModifier = accessModifier;
    }
}
