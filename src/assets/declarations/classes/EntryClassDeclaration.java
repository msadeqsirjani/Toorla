package assets.declarations.classes;

import assets.expressions.Identifier;
import visitor.Visitor;

public class EntryClassDeclaration extends ClassDeclaration {
    public EntryClassDeclaration(Identifier name) {
        super(name);
    }

    public EntryClassDeclaration(Identifier name, Identifier parentName) {
        super(name, parentName);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "EntryClassDeclaration";
    }
}
