package name.analyser.comile.error.exception;

public abstract class CompileErrorException extends Exception {
    protected int line;
    protected int column;

    public CompileErrorException() {

    }

    public CompileErrorException(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public void setPlace(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public abstract String toString();
}
