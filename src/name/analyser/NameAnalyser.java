package name.analyser;

import assets.Program;
import symbol.table.SymbolTable;
import symbol.table.exceptions.ItemAlreadyExistsException;
import symbol.table.items.ClassSymbolTableItem;
import utilities.graph.Graph;

public class NameAnalyser {
    private Program program;
    private Graph<String> hierarchy;

    public NameAnalyser(Program program) {
        this.program = program;
    }

    public void analyse() {
        NameCollectionPass nameCollectionPass = new NameCollectionPass();
        var classPartnershipExtractorPass = new ClassPartnershipExtractorPass();
        NameCheckingPass nameCheckingPass = new NameCheckingPass();
        ReportingPass reportingPass = new ReportingPass();
        prepare();
        nameCollectionPass.analyse(program);
        classPartnershipExtractorPass.analyse(program);
        nameCheckingPass.analyse(program);
        this.hierarchy = classPartnershipExtractorPass.getResult();
        reportingPass.analyse(program);
        program.accept(new NameTreePrinter());
    }

    private void prepare() {
        SymbolTable.root = new SymbolTable();
        var classAnySymbolTableItem = new ClassSymbolTableItem("Any");

        classAnySymbolTableItem.setTable(new SymbolTable(SymbolTable.root));

        try {
            SymbolTable.root.put(classAnySymbolTableItem);
        } catch (ItemAlreadyExistsException ignored) {
        }

        SymbolTable.push(classAnySymbolTableItem.getTable());
    }

    public Graph<String> getHierarchy() {
        return hierarchy;
    }
}
