import ananlyzer.NameAnalyzer;
import gen.ToorlaLexer;
import gen.ToorlaParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Compiler {
    public void compile(CharStream textStream) {
        var lexer = new ToorlaLexer(textStream);
        var stream = new CommonTokenStream(lexer);
        var parser = new ToorlaParser(stream);
        var program = parser.program().mProgram;
        var analyzer = new NameAnalyzer(program);
        analyzer.analyze();
    }
}
