package symbol.table.items;

import assets.declaration.description.member.AccessModifier;
import assets.declaration.description.member.MethodDeclaration;
import types.Type;

import java.util.List;

public class MethodSymbolTableItem extends SymbolTableItem {
    private static final String methodModifier = "method_";

    private Type returnedType;
    private List<Type> argumentsType;
    private AccessModifier accessModifier;

    public MethodSymbolTableItem(String name, Type returnedType, List<Type> argumentsType, AccessModifier accessModifier) {
        this.name = name;
        this.returnedType = returnedType;
        this.argumentsType = argumentsType;
        this.accessModifier = accessModifier;
    }

    @Override
    public String getKey() {
        return MethodSymbolTableItem.methodModifier + name;
    }

    public Type getReturnedType() {
        return returnedType;
    }

    public List<Type> getArgumentsType() {
        return argumentsType;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }
}
