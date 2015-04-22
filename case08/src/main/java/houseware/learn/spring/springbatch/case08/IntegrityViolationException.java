package houseware.learn.spring.springbatch.case08;

/**
 *
 * @author fphilip@houseware.es
 */
public class IntegrityViolationException extends RuntimeException {

    public IntegrityViolationException() {
        super();
    }

    public IntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public IntegrityViolationException(String message) {
        super(message);
    }

    public IntegrityViolationException(Throwable cause) {
        super(cause);
    }

}
