package ananlyzer;


import assets.Program;
import symbol.table.SymbolTable;
import symbol.table.exceptions.ItemAlreadyExistsException;
import symbol.table.items.ClassSymbolTableItem;
import utilities.graph.Graph;

public class NameAnalyzer {
    private Program program;
    private Graph<String> classHierarchy;

    public NameAnalyzer(Program p) {
        program = p;
    }

    public void analyze() {
        var nameCollectionPass = new NameCollectionPass();
        var classParentshipExtractorPass = new ClassParentshipExtractorPass();
        var nameCheckingPass = new NameCheckingPass();
        var reportingPass = new ReportingPass();
        prepare();
        nameCollectionPass.analyze(program);
        classParentshipExtractorPass.analyze(program);
        nameCheckingPass.analyze(program);
        classHierarchy = classParentshipExtractorPass.getResult();
        reportingPass.analyze(program);
        program.accept(new NameTreePrinter());
    }

    private void prepare() {
        SymbolTable.root = new SymbolTable();
        ClassSymbolTableItem classAnySymbolTableItem = new ClassSymbolTableItem("Any");
        classAnySymbolTableItem.setSymbolTable(new SymbolTable(SymbolTable.root));
        try {
            SymbolTable.root.put(classAnySymbolTableItem);
        } catch (ItemAlreadyExistsException ignored) {
        }
        SymbolTable.push(classAnySymbolTableItem.getSymbolTable());
    }

    public Graph getClassHierarchy() {
        return classHierarchy;
    }
}