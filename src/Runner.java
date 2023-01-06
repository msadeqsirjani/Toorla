import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;
import java.nio.file.Paths;

public class Runner {
    public static void main(String[] args) throws IOException {
        var path = Paths.get("sample", "sample-4.trl");
        CharStream textStream = CharStreams.fromFileName(path.toString());
        Compiler compiler = new Compiler();
        compiler.compile(textStream);
    }
}
