package exceptions;

public class NoTransactionInBaseException extends Exception{
    public NoTransactionInBaseException() {
    }

    public NoTransactionInBaseException(String message) {
        super(message);
    }
}
