package houseware.learn.spring.batch.case06;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * @author fphilip@houseware.es
 */
public class DummyItemReader implements ItemReader<Dummy> {
    private long i = 1;

    @Override
    public Dummy read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (i > 100) {
            return null;
        }

        return new Dummy(i++);
    }
}
