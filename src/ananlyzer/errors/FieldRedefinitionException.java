package ananlyzer.errors;

public class FieldRedefinitionException extends CompileErrorException {
    String fieldName;

    public FieldRedefinitionException(String name, int atLine, int atColumn) {
        super(atLine, atColumn);
        fieldName = name;
    }

    public FieldRedefinitionException(String name) {
        fieldName = name;
    }

    @Override
    public String toString() {
        return String.format("Error:Line:%d:Redefinition of Field %s", atLine, fieldName);
    }
}