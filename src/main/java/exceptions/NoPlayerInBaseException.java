package exceptions;

public class NoPlayerInBaseException extends Exception{
    public NoPlayerInBaseException() {
    }

    public NoPlayerInBaseException(String message) {
        super(message);
    }
}
