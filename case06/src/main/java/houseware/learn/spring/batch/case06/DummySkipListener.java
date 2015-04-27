package houseware.learn.spring.batch.case06;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.SkipListener;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class DummySkipListener implements SkipListener<Dummy, Dummy> {

    @Override
    public void onSkipInRead(Throwable throwable) {
        log.info("DummySkipListener.onSkipInRead:" + throwable.getMessage());

    }

    @Override
    public void onSkipInWrite(Dummy dummy, Throwable throwable) {
        log.info("DummySkipListener.onSkipInWrite:" + dummy + ", " + throwable.getMessage());

    }

    @Override
    public void onSkipInProcess(Dummy dummy, Throwable throwable) {
        log.info("DummySkipListener.onSkipInProcess:" + dummy + ", " + throwable.getMessage());

    }
}
