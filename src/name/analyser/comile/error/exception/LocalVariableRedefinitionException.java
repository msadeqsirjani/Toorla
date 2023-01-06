package name.analyser.comile.error.exception;

public class LocalVariableRedefinitionException extends CompileErrorException {
    private String variableName;

    public LocalVariableRedefinitionException(String variableName) {
        this.variableName = variableName;
    }

    public LocalVariableRedefinitionException(String variableName, int line, int column) {
        super(line, column);
        this.variableName = variableName;
    }

    @Override
    public String toString() {
        return String.format("Error:Line:%d:Redefinition of Local Variable %s in current scope", line, variableName);
    }
}
