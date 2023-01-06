package types.singles;

import assets.declarations.classes.ClassDeclaration;

public class UserDefinedType extends SingleType {
    private ClassDeclaration typeClass;

    public UserDefinedType(ClassDeclaration cd) {
        typeClass = cd;
    }

    public ClassDeclaration getClassDeclaration() {
        return typeClass;
    }

    public void setClassDeclaration(ClassDeclaration typeClass) {
        this.typeClass = typeClass;
    }

    @Override
    public String toString() {
        return "(UserDefined," + typeClass.getName().getName() + ")";
    }
}
