package symbol.table.items.variables;

import assets.declarations.classes.members.AccessModifier;
import types.Type;

public class FieldSymbolTableItem extends VariableSymbolTableItem {

    private AccessModifier accessModifier;

    public FieldSymbolTableItem(String name, AccessModifier accessModifier, Type type) {
        this.name = name;
        this.accessModifier = accessModifier;
        this.varType = type;
    }

    public FieldSymbolTableItem(String name, Type type) {
        this.name = name;
        this.accessModifier = AccessModifier.PRIVATE;
        this.varType = type;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public void setAccessModifier(AccessModifier accessModifier) {
        this.accessModifier = accessModifier;
    }


}
