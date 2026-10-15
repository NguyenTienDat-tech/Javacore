package exception;

public class ValidationException extends RuntimeException {
    public ValidationException(String messagge) {
        super(messagge);
    }
}
