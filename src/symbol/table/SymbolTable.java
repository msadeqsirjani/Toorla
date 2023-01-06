package symbol.table;

import symbol.table.exceptions.ItemAlreadyExistsException;
import symbol.table.exceptions.ItemNotFoundException;
import symbol.table.items.SymbolTableItem;

import java.util.*;

public class SymbolTable {
    private SymbolTable pre;
    private Map<String, SymbolTableItem> items;

    // Static members region

    private static SymbolTable top;
    public static SymbolTable root;

    private static Stack<SymbolTable> stack = new Stack<>();
    private static Queue<SymbolTable> queue = new LinkedList<>();

    public static SymbolTable top() {
        return top;
    }

    public static void pushFromQueue() {
        push(queue.remove());
    }

    public static void push(SymbolTable symbolTable) {
        if (top != null) stack.push(top);
        top = symbolTable;
        queue.offer(symbolTable);
    }

    public static void pop() {
        top = stack.pop();
    }

    // End of static members region

    public SymbolTable() {
        this(null);
    }

    public SymbolTable(SymbolTable pre) {
        this.pre = pre;
        this.items = new HashMap<>();
    }

    public void put(SymbolTableItem item) throws ItemAlreadyExistsException {
        if (items.containsKey(item.getKey())) throw new ItemAlreadyExistsException();
        items.put(item.getKey(), item);
    }

    public SymbolTableItem get(String key) throws ItemNotFoundException {
        Set<SymbolTable> visitedSymbolTables = new HashSet<>();
        SymbolTable currentSymbolTable = this;
        do {
            visitedSymbolTables.add(currentSymbolTable);
            SymbolTableItem value = currentSymbolTable.items.get(key);
            if (value == null) currentSymbolTable = currentSymbolTable.getPreSymbolTable();
            else return value;
        } while (currentSymbolTable != null && !visitedSymbolTables.contains(currentSymbolTable));
        throw new ItemNotFoundException();
    }

    public SymbolTableItem getInParentScopes(String key) throws ItemNotFoundException {
        if (pre == null) throw new ItemNotFoundException();
        else return pre.get(key);
    }

    public SymbolTable getPreSymbolTable() {
        return pre;
    }

    public void setPreSymbolTable(SymbolTable symbolTable) {
        pre = symbolTable;
    }
}
