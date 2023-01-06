package name.analyser;

import assets.Program;
import assets.declaration.description.ClassDeclaration;
import assets.declaration.description.EntryClassDeclaration;
import assets.declaration.description.member.MethodDeclaration;
import assets.declaration.local.variable.ParameterDeclaration;
import assets.statement.Block;
import assets.statement.Conditional;
import assets.statement.While;
import assets.statement.local.variable.LocalVariableDef;
import symbol.table.SymbolTable;
import symbol.table.exceptions.ItemNotFoundException;
import symbol.table.items.variables.LocalVariableSymbolTableItem;
import symbol.table.items.variables.VariableSymbolTableItem;
import visitor.TreePrinter;

public class NameTreePrinter extends TreePrinter {
    @Override
    public Void visit(Program declaration) {
        SymbolTable.pushFromQueue();

        super.visit(declaration);

        SymbolTable.pop();

        return null;
    }

    @Override
    public Void visit(ClassDeclaration declaration) {
        SymbolTable.pushFromQueue();

        super.visit(declaration);

        SymbolTable.pop();

        return null;
    }

    @Override
    public Void visit(EntryClassDeclaration declaration) {
        SymbolTable.pushFromQueue();

        super.visit(declaration);

        SymbolTable.pop();

        return null;
    }

    @Override
    public Void visit(MethodDeclaration declaration) {
        SymbolTable.pushFromQueue();

        super.visit(declaration);

        SymbolTable.pop();

        return null;
    }

    @Override
    public Void visit(Block statement) {
        SymbolTable.pushFromQueue();

        super.visit(statement);

        SymbolTable.pop();

        return null;
    }

    @Override
    public Void visit(Conditional statement) {
        System.out.print("(if ");

        statement.getCondition().accept(this);

        System.out.print(" ");

        SymbolTable.pushFromQueue();

        statement.getThen().accept(this);

        SymbolTable.pop();

        System.out.print(" ");

        SymbolTable.pushFromQueue();

        statement.getTheElse().accept(this);

        SymbolTable.pop();

        System.out.println(")");

        return null;
    }

    @Override
    public Void visit(While statement) {
        System.out.print("(while ");

        statement.getExpression().accept(this);

        System.out.print(" ");

        SymbolTable.pushFromQueue();

        statement.getBody().accept(this);

        SymbolTable.pop();

        System.out.println(")");

        return null;
    }

    @Override
    public Void visit(ParameterDeclaration declaration) {
        String parameterName = declaration.getIdentifier().getName();

        int parameterIndex = getLocalVariableIndex(parameterName);

        System.out.print("( ");
        System.out.print("(Identifier," + parameterName + "_" + parameterIndex + ")");
        System.out.print(" : ");
        System.out.print(declaration.getType());
        System.out.print(")");

        return null;
    }

    @Override
    public Void visit(LocalVariableDef statement) {
        String localVarName = statement.getLocalVariable().getName();

        int localVarIndex = getLocalVariableIndex(localVarName);

        System.out.print("(var ");
        System.out.print("(Identifier," + localVarName + "_" + localVarIndex + ")");
        System.out.print(" ");

        statement.getInitialValue().accept(this);

        System.out.println(")");

        return null;
    }

    private int getLocalVariableIndex(String name) {
        int localVariableIndex = 0;

        try {
            var parameterSymbolTableItem = (LocalVariableSymbolTableItem) (SymbolTable.top().get(VariableSymbolTableItem.variableModifier + name));
            localVariableIndex = parameterSymbolTableItem.getIndex();
        } catch (ItemNotFoundException ex) {
            ex.printStackTrace();
        }

        return localVariableIndex;
    }
}
