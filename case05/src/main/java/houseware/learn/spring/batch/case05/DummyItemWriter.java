package houseware.learn.spring.batch.case05;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class DummyItemWriter implements ItemWriter<Dummy> {

    @Override
    public void write(List<? extends Dummy> items) throws Exception {
        for (Dummy item : items) {
            log.info("DummyItemWriter:" + item);
        }

    }
}
