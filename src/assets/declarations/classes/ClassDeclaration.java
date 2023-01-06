package assets.declarations.classes;

import assets.declarations.Declaration;
import assets.declarations.classes.members.ClassMemberDeclaration;
import assets.declarations.classes.members.FieldDeclaration;
import assets.declarations.classes.members.MethodDeclaration;
import assets.expressions.Identifier;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class ClassDeclaration extends Declaration {
    private Identifier name;
    private Identifier parentName;

    private ArrayList<ClassMemberDeclaration> members = new ArrayList<>();

    public ClassDeclaration(Identifier name) {
        this.name = name;
    }

    public ClassDeclaration(Identifier name, Identifier parentName) {
        this.name = name;
        this.parentName = parentName;
    }

    public Identifier getName() {
        return name;
    }

    public void setName(Identifier name) {
        this.name = name;
    }

    public Identifier getParentName() {
        return parentName;
    }

    public ArrayList<ClassMemberDeclaration> getClassMembers() {
        return members;
    }

    public void addFieldsDeclarations(List<FieldDeclaration> varDeclarations) {
        this.members.addAll(varDeclarations);
    }

    public void addMethodDeclaration(MethodDeclaration methodDeclaration) {
        this.members.add(methodDeclaration);
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "ClassDeclaration";
    }
}
