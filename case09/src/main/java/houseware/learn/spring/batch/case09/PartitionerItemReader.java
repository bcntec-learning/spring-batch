package houseware.learn.spring.batch.case09;

import lombok.Getter;
import lombok.Setter;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.listener.ChunkListenerSupport;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.item.*;

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
