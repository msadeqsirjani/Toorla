package compiler;

import gen.ToorlaLexer;
import gen.ToorlaParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.file.Paths;

public class Compiler {
    public static void main(String[] args) throws IOException {
        var path = Paths.get("sample", "input-2.trl");
        var stream = CharStreams.fromFileName(path.toString());
        var lexer = new ToorlaLexer(stream);
        var tokens = new CommonTokenStream(lexer);
        var parser = new ToorlaParser(tokens);
        parser.setBuildParseTree(true);
        var tree = parser.program();
        var walker = new ParseTreeWalker();
        var listener = new ProgramPrinter();

        walker.walk(listener, tree);
    }
}
