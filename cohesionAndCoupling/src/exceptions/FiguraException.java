package exceptions;

public class FiguraException extends Exception {
    public FiguraException() {
        super("Figura não reconhecida.");
    }

    public FiguraException(String message) {
        super(message);
    }
}