package ananlyzer.errors;

import assets.declarations.classes.ClassDeclaration;
import assets.expressions.Identifier;
import symbol.table.SymbolTable;
import symbol.table.exceptions.ItemAlreadyExistsException;
import symbol.table.items.ClassSymbolTableItem;

public class ClassRedefinitionException extends CompileErrorException {
    private ClassDeclaration classDeclaration;
    private int seenClassesNum;
    private String oldName;

    public ClassRedefinitionException(ClassDeclaration classDeclaration, int seenClassesNum) {
        super(classDeclaration.getName().line, classDeclaration.getName().col);
        this.classDeclaration = classDeclaration;
        this.seenClassesNum = seenClassesNum;
        this.oldName = classDeclaration.getName().getName();
    }


    public void handle() {
        String newClassName = "$" + seenClassesNum + oldName;
        ClassSymbolTableItem thisClass = new ClassSymbolTableItem(newClassName);
        thisClass.setSymbolTable(SymbolTable.top());
        thisClass.setParentSymbolTable(SymbolTable.top().getPreSymbolTable());
        Identifier newClassIdentifier = new Identifier(newClassName);
        newClassIdentifier.line = atLine;
        newClassIdentifier.col = atColumn;
        try {
            SymbolTable.root.put(thisClass);
            classDeclaration.setName(newClassIdentifier);
        } catch (ItemAlreadyExistsException itemAlreadyExists) {
            itemAlreadyExists.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format("Error:Line:%d:Redefinition of Class %s", atLine, oldName);
    }
}