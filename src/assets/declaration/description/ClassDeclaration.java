package assets.declaration.description;

import assets.declaration.Declaration;
import assets.declaration.description.member.ClassMemberDeclaration;
import assets.declaration.description.member.FieldDeclaration;
import assets.declaration.description.member.MethodDeclaration;
import assets.expression.Identifier;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class ClassDeclaration extends Declaration {
    private Identifier name;
    private Identifier parent;
    private ArrayList<ClassMemberDeclaration> members;

    public ClassDeclaration() {
        this.members = new ArrayList<>();
    }

    public ClassDeclaration(Identifier name) {
        this();
        this.name = name;
    }

    public ClassDeclaration(Identifier name, Identifier parent) {
        this(name);
        this.parent = parent;
    }

    public Identifier getName() {
        return name;
    }

    public void setName(Identifier name) {
        this.name = name;
    }

    public Identifier getParent() {
        return parent;
    }

    public ArrayList<ClassMemberDeclaration> getMembers() {
        return members;
    }

    public void addFieldsDeclaration(List<FieldDeclaration> declarations) {
        this.members.addAll(declarations);
    }

    public void addMethodsDeclaration(List<MethodDeclaration> declarations) {
        this.members.addAll(declarations);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "class-declaration";
    }
}
