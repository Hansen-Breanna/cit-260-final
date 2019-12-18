/**
 * The FileIsEmptyException method
 * This method does a custom exception for an empty file
 */
public class FileIsEmptyException extends Throwable {
    public FileIsEmptyException(String message) {
        super(message);
    }
}
