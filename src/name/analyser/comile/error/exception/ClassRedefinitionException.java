package name.analyser.comile.error.exception;

import assets.declaration.description.ClassDeclaration;
import assets.expression.Identifier;
import symbol.table.SymbolTable;
import symbol.table.exceptions.ItemAlreadyExistsException;
import symbol.table.items.ClassSymbolTableItem;

public class ClassRedefinitionException extends CompileErrorException {
    private ClassDeclaration declaration;
    private int seenClassNumbers;
    private String previousName;

    public ClassRedefinitionException(ClassDeclaration declaration, int number) {
        super(declaration.getName().line, declaration.getName().column);
        this.declaration = declaration;
        this.seenClassNumbers = number;
        this.previousName = declaration.getName().getName();
    }

    public void handle() {
        var className = "$" + seenClassNumbers + previousName;
        var thisClass = new ClassSymbolTableItem(className);
        thisClass.setTable(SymbolTable.top());
        thisClass.setParent(SymbolTable.top().getTable());
        var identifier = new Identifier(className);
        identifier.line = line;
        identifier.column = column;

        try {
            SymbolTable.root.put(thisClass);
            thisClass.setName(className);
        } catch (ItemAlreadyExistsException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format("Error:Line:%d:Redefinition of Class %s", line, previousName);
    }
}
