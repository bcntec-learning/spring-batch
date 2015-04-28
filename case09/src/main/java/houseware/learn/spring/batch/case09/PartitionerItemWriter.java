package houseware.learn.spring.batch.case09;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class PartitionerItemWriter implements ItemWriter<PartitionerItem> {


    @Override
    public void write(List<? extends PartitionerItem> items) throws Exception {
        for (PartitionerItem item : items) {
            log.info("item:" + item);
        }
    }

}
