package houseware.learn.spring.batch.case06;

/**
 * @author fphilip@houseware.es
 */
public class DummyException extends RuntimeException {
    private boolean fatal = false;

    public DummyException(String message) {
        this(message, false);
    }

    public DummyException(String message, boolean fatal) {
        super(message);
        this.fatal = fatal;
    }

    public boolean isFatal() {
        return fatal;
    }
}
