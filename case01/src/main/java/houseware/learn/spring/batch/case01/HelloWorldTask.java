package houseware.learn.spring.batch.case01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class HelloWorldTask implements Tasklet {


    public RepeatStatus execute(StepContribution stepContribution,
                                ChunkContext chunkContext) throws Exception {
        log.info("Hello World!");
        return RepeatStatus.FINISHED;
    }
}