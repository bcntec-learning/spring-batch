package houseware.learn.spring.batch.case09;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
public class PartitionerItemStream implements ItemStream {
    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {


    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        String p = executionContext.getString(CustomPartitioner.PARTITION_KEY);
        log.info(p);
    }

    @Override
    public void close() throws ItemStreamException {


    }
}
