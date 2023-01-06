package symbol.table.items.variables;

import types.AnonymousType;

public class LocalVariableSymbolTableItem extends VariableSymbolTableItem {
    private int index;

    public LocalVariableSymbolTableItem(String name, int index) {
        this.name = name;
        this.varType = new AnonymousType();
        this.index = index;
    }


    public int getIndex() {
        return index;
    }
}
