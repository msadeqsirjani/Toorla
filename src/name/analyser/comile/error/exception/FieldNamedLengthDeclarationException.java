package name.analyser.comile.error.exception;

public class FieldNamedLengthDeclarationException extends CompileErrorException {
    public FieldNamedLengthDeclarationException(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return String.format("Error:Line:%d:Definition of length as field of a class", line);
    }
}
