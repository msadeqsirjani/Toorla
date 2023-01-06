package ananlyzer.errors;

public class MethodRedefinitionException extends CompileErrorException {
    String methodName;

    public MethodRedefinitionException(String name, int atLine, int atColumn) {
        super(atLine, atColumn);
        methodName = name;
    }

    public MethodRedefinitionException(String name) {
        methodName = name;
    }

    @Override
    public String toString() {
        return String.format("Error:Line:%d:Redefinition of Method %s", atLine, methodName);
    }

}