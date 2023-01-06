package name.analyser;

import assets.Program;
import symbol.table.SymbolTable;
import symbol.table.exceptions.ItemNotFoundException;
import symbol.table.items.ClassSymbolTableItem;
import utilities.graph.Graph;
import utilities.graph.GraphDoesNotContainNodeException;
import utilities.graph.NodeAlreadyExists;

public class ClassPartnershipExtractorPass implements INameAnalysingPass<Graph<String>> {
    private Graph<String> inheritanceGraph;

    public ClassPartnershipExtractorPass() {
        this.inheritanceGraph = new Graph<>();
    }

    @Override
    public void analyse(Program program) {
        try {
            inheritanceGraph.addNode("Any");
        } catch (NodeAlreadyExists ignored) {
        }

        for (var thisClass : program.getClasses()) {
            String className = thisClass.getName().getName();
            try {
                inheritanceGraph.addNode(className);
            } catch (NodeAlreadyExists ignored) {
            }

            if (thisClass.getParent().getName() == null) {
                try {
                    inheritanceGraph.addNodeAsParentOf(className, "Any");
                } catch (GraphDoesNotContainNodeException ignored) {
                }
                continue;
            }

            var parentName = thisClass.getParent().getName();

            try {
                inheritanceGraph.addNodeAsParentOf(className, parentName);
                ClassSymbolTableItem parentSTI = (ClassSymbolTableItem) SymbolTable.root.get(ClassSymbolTableItem.classModifier + parentName);
                ClassSymbolTableItem thisClassSTI = (ClassSymbolTableItem) SymbolTable.root.get(ClassSymbolTableItem.classModifier + thisClass.getName().getName());
                thisClassSTI.setParent(parentSTI.getTable());
                thisClassSTI.getTable().setTable(parentSTI.getTable());
            } catch (ItemNotFoundException | GraphDoesNotContainNodeException ignored) {
            }
        }
    }

    @Override
    public Graph<String> getResult() {
        return inheritanceGraph;
    }
}
