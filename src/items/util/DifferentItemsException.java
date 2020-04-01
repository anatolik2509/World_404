package items.util;

public class DifferentItemsException extends RuntimeException {
    public DifferentItemsException() {
    }

    public DifferentItemsException(String message) {
        super(message);
    }

    public DifferentItemsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DifferentItemsException(Throwable cause) {
        super(cause);
    }
}
