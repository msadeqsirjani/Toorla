package assets;

import visitor.Visitor;

public abstract class Tree {
    public int line;
    public int column;

    public abstract <T> T accept(Visitor<T> visitor);
    public abstract String toString();
}
