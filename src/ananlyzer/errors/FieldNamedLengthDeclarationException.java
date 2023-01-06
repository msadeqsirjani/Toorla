package ananlyzer.errors;

public class FieldNamedLengthDeclarationException extends CompileErrorException {
    public FieldNamedLengthDeclarationException(int atLine, int atColumn) {
        super(atLine, atColumn);
    }


    @Override
    public String toString() {
        return String.format("Error:Line:%d:Definition of length as field of a class", atLine);
    }
}