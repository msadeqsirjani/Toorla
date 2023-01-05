package assets;

import assets.declaration.description.ClassDeclaration;
import visitor.Visitor;

import java.util.ArrayList;

public class Program extends Tree {
    private ArrayList<ClassDeclaration> classes;

    public Program() {
        classes = new ArrayList<>();
    }

    public ArrayList<ClassDeclaration> getClasses() {
        return classes;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "program";
    }
}
