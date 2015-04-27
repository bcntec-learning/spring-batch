package houseware.learn.spring.batch.case05;

import org.springframework.batch.item.ItemProcessor;

/**
 * @author fphilip@houseware.es
 */
public class DummyItemProcessor implements ItemProcessor<Dummy, Dummy> {


    @Override
    public Dummy process(Dummy item) throws Exception {
        item.setCategory(item.getCategory().toUpperCase());
        return item;
    }
}
