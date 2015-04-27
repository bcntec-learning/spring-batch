package houseware.learn.spring.batch.case09;

import lombok.Getter;
import lombok.Setter;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * @author fphilip@houseware.es
 */
public class PartitionerItemReader implements ItemReader<PartitionerItem> {
    private long i = 1;
    @Getter @Setter
    private long size=1000;
    @Override
    public PartitionerItem read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (i > size) {
            return null;
        }

        return new PartitionerItem(i++);
    }
}
