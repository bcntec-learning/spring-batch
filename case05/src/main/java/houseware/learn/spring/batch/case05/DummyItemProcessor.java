package houseware.learn.spring.batch.case05;

import org.springframework.batch.item.ItemProcessor;

import lombok.extern.slf4j.Slf4j;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
public class DummyItemProcessor implements ItemProcessor<Dummy, Dummy> {


    @Override
    public Dummy process(Dummy item) throws Exception {
        item.setCategory(item.getCategory().toUpperCase());
        log.info(item.toString());
        return item;
    }
}
