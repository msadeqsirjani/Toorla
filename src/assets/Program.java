package assets;

import assets.declarations.classes.ClassDeclaration;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Program extends Tree {
    private ArrayList<ClassDeclaration> classes = new ArrayList<>();


    public void addClass(ClassDeclaration classDeclaration) {
        classes.add(classDeclaration);
    }

    public List<ClassDeclaration> getClasses() {
        return classes;
    }

    @Override
    public String toString() {
        return "Program";
    }

    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
