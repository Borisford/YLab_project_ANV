package exceptions;

public class EqualNamesException extends Exception{
    public EqualNamesException() {
    }

    public EqualNamesException(String message) {
        super(message);
    }
}
