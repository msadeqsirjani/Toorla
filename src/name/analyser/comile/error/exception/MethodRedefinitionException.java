package name.analyser.comile.error.exception;

public class MethodRedefinitionException extends CompileErrorException {
    private String methodName;

    public MethodRedefinitionException(String methodName) {
        this.methodName = methodName;
    }

    public MethodRedefinitionException(String methodName, int line, int column){
        super(line, column);
        this.methodName = methodName;
    }

    @Override
    public String toString() {
        return String.format("Error:Line:%d:Redefinition of Method %s", line, methodName);
    }
}
