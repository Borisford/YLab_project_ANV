package exceptions;

public class WrongValidationException extends Exception{
    public WrongValidationException() {
    }

    public WrongValidationException(String message) {
        super(message);
    }
}
