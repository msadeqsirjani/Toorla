package name.analyser.comile.error.exception;

public abstract class CompileErrorException extends Exception {
    private int line;
    private int column;

    public CompileErrorException() {

    }

    public CompileErrorException(int atLine, int atColumn) {
        this.line = atLine;
        this.column = atColumn;
    }

    public void setPlace(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public abstract String toString();
}
