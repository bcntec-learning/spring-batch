package houseware.learn.spring.springbatch.case05;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class DummyItemStream implements ItemStream {

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        log.info("DummyItemStream.open");
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        //todo fphilip

        log.info("DummyItemStream.update");
    }

    @Override
    public void close() throws ItemStreamException {

        log.info("DummyItemStream.close");

    }
}
