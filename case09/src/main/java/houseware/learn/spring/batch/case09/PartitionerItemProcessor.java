package houseware.learn.spring.batch.case09;

import org.springframework.batch.item.ItemProcessor;

import java.util.Date;

/**
 * @author fphilip@houseware.es
 */
public class PartitionerItemProcessor implements ItemProcessor<PartitionerItem,PartitionerItem> {

    @Override
    public PartitionerItem process(PartitionerItem item) throws Exception {
        item.setTimestamp(new Date());
        return item;
    }
}
