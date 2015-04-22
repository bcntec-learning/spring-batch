package houseware.learn.spring.springbatch.case06;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class DummyItemProcessor implements ItemProcessor<Dummy, Dummy> {


    @Override
    public Dummy process(Dummy item) throws Exception {
        log.info("process:" + item);
        if (item.getId() == 71) {
            throw new DummyException("we can't write a 71");
        }
        return item;
    }
}
