package ananlyzer.errors;

public class LocalVariableRedefinitionException extends CompileErrorException {
    String varName;

    public LocalVariableRedefinitionException(String name, int atLine, int atColumn) {
        super(atLine, atColumn);
        varName = name;
    }

    public LocalVariableRedefinitionException(String name) {
        varName = name;
    }

    @Override
    public String toString() {
        return String.format("Error:Line:%d:Redefinition of Local Variable %s in current scope", atLine, varName);
    }
}