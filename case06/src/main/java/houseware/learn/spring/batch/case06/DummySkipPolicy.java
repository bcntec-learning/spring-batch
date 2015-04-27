package houseware.learn.spring.batch.case06;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;

/**
 * @author fphilip@houseware.es
 */
public class DummySkipPolicy implements SkipPolicy {

    @Override
    public boolean shouldSkip(Throwable throwable, int i) throws SkipLimitExceededException {
        return (throwable instanceof DummyException) ? ((DummyException) throwable).isFatal() : false;

    }
}
