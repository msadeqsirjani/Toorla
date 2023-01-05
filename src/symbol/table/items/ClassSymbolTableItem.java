package symbol.table.items;

import symbol.table.SymbolTable;

public class ClassSymbolTableItem extends SymbolTableItem {
    public static final String classModifier = "class_";

    private SymbolTable table;
    private SymbolTable parent;

    public ClassSymbolTableItem(String name) {
        this.name = name;
    }

    @Override
    public String getKey() {
        return ClassSymbolTableItem.classModifier + name;
    }

    public SymbolTable getTable() {
        return table;
    }

    public void setTable(SymbolTable table) {
        this.table = table;
    }

    public SymbolTable getParent() {
        return parent;
    }

    public void setParent(SymbolTable parent) {
        this.parent = parent;
    }
}
