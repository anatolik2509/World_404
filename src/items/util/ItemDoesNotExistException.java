package items.util;

public class ItemDoesNotExistException extends RuntimeException {
    public ItemDoesNotExistException() {
    }

    public ItemDoesNotExistException(String message) {
        super(message);
    }

    public ItemDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemDoesNotExistException(Throwable cause) {
        super(cause);
    }
}
