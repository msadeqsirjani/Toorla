package assets;

import name.analyser.comile.error.exception.CompileErrorException;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public abstract class Tree {
    public int line;
    public int column;
    public List<CompileErrorException> errors = new ArrayList<>();

    public abstract <T> T accept(Visitor<T> visitor);

    public abstract String toString();
}
