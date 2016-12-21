package houseware.learn.spring.batch.case09;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fphilip@houseware.es
 */
public class ResetDataTasklet implements Tasklet {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        jdbcTemplate.execute("delete from products ");
        return RepeatStatus.FINISHED;
    }

    @Transactional
    public void reset() {
    }

    public void waitForTest() throws InterruptedException {
        Thread.sleep(1000);
    }
}
