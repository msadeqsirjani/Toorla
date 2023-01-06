package name.analyser.comile.error.exception;

public class FieldRedefinitionException extends CompileErrorException {
    private String fieldName;

    public FieldRedefinitionException(String fieldName) {
        this.fieldName = fieldName;
    }

    public FieldRedefinitionException(String fieldName, int line, int column){
        super(line, column);
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return String.format("Error:Line:%d:Redefinition of Field %s", line, fieldName);
    }
}
