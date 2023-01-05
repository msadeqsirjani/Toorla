package symbol.table;

import java.util.ArrayList;

public class Stack<T> {
    private int top;
    private ArrayList<T> elements;

    public Stack() {
        this.top = -1;
        this.elements = new ArrayList<>();
    }

    public void push(T element) {
        this.elements.add(element);
        this.top++;
    }

    public T pop() {
        if (this.top == -1) {
            return null;
        }

        --top;

        var element = elements.get(top + 1);

        elements.remove(top + 1);

        return element;
    }
}
