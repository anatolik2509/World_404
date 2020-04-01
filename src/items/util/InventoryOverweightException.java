package items.util;

public class InventoryOverweightException extends RuntimeException {
    public InventoryOverweightException() {
    }

    public InventoryOverweightException(String message) {
        super(message);
    }

    public InventoryOverweightException(String message, Throwable cause) {
        super(message, cause);
    }

    public InventoryOverweightException(Throwable cause) {
        super(cause);
    }
}
