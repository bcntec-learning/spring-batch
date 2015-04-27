package houseware.learn.spring.batch.case06;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.listener.ItemListenerSupport;

import java.util.List;


/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class DummyItemListener extends ItemListenerSupport<Dummy, Dummy> {

    @Override
    public void afterRead(Dummy item) {
        info("afterRead:" + item);
    }

    @Override
    public void beforeRead() {
        info("beforeRead");
    }

    @Override
    public void onReadError(Exception ex) {
        info("onReadError:" + ex.getMessage());
    }

    @Override
    public void afterProcess(Dummy item, Dummy result) {
        info("afterProcess:" + item);
    }

    @Override
    public void beforeProcess(Dummy item) {
        info("beforeProcess:" + item);
    }

    @Override
    public void onProcessError(Dummy item, Exception e) {
        info("onProcessError:" + item);
    }

    @Override
    public void afterWrite(List<? extends Dummy> item) {
        info("afterWrite:" + item);
    }

    @Override
    public void beforeWrite(List<? extends Dummy> item) {
        info("beforeWrite:" + item);
    }

    @Override
    public void onWriteError(Exception ex, List<? extends Dummy> item) {
        info("onWriteError:" + item.size() + " " + ex.getMessage());
    }


    private void info(String m) {
        log.info(m);
    }
}
