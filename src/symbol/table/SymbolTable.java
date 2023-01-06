package symbol.table;

import symbol.table.exceptions.ItemAlreadyExistsException;
import symbol.table.exceptions.ItemNotFoundException;
import symbol.table.items.SymbolTableItem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SymbolTable {
    private SymbolTable table;
    private Map<String, SymbolTableItem> items;

    // start static members

    private static SymbolTable top;
    public static SymbolTable root;

    private static Stack<SymbolTable> stack = new Stack<>();
    private static Queue<SymbolTable> queue = new LinkedList<>();

    public static SymbolTable top() {
        return top;
    }

    public static void push(SymbolTable table) {
        if (top != null) {
            stack.push(top);
        }

        top = table;

        queue.offer(table);
    }

    public static void pushFromQueue() {
        push(queue.remove());
    }

    public static void pop() {
        top = stack.pop();
    }

    // end static members

    public SymbolTable() {
        this(null);
    }

    public SymbolTable(SymbolTable table) {
        this.table = table;
    }

    public void put(SymbolTableItem item) throws ItemAlreadyExistsException {
        if (items.containsKey(item.getKey())) {
            throw new ItemAlreadyExistsException();
        }

        items.put(item.getKey(), item);
    }

    public SymbolTableItem get(String key) throws ItemNotFoundException {
        var visited = new HashSet<SymbolTable>();
        SymbolTable current = this;

        do {
            visited.add(current);
            var value = current.items.get(key);

            if (value == null) {
                current = current.getTable();
            } else {
                return value;
            }
        } while (current != null && !visited.contains(current));

        throw new ItemNotFoundException();
    }

    public SymbolTableItem getInParentScope(String key) throws ItemNotFoundException {
        if (table == null) {
            throw new ItemNotFoundException();
        } else {
            return table.get(key);
        }
    }

    public SymbolTable getTable() {
        return table;
    }

    public void setTable(SymbolTable table) {
        this.table = table;
    }
}
