package assets.declaration.description;

import assets.expression.Identifier;
import visitor.Visitor;

public class EntryClassDeclaration extends ClassDeclaration {
    public EntryClassDeclaration(Identifier name) {
        super(name);
    }

    public EntryClassDeclaration(Identifier name, Identifier parent) {
        super(name, parent);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "entry-class-declaration";
    }
}
