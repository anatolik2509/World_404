package items.util;

public class NegativeAmountException extends RuntimeException {
    public NegativeAmountException() {
    }

    public NegativeAmountException(String message) {
        super(message);
    }

    public NegativeAmountException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeAmountException(Throwable cause) {
        super(cause);
    }
}
