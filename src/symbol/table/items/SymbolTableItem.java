package symbol.table.items;

public abstract class SymbolTableItem {
    protected String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getKey();
}
