package houseware.learn.spring.batch.case06;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
public class Step2Task implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        JobParameters jobParameters = chunkContext.getStepContext().getStepExecution().getJobParameters();
        StepExecution stepExecution = chunkContext.getStepContext().getStepExecution();

        Long result = (Long)chunkContext.getStepContext().getJobExecutionContext().get("result");
        Long jobInstanceId = chunkContext.getStepContext().getStepExecution().getJobExecution().getId();
        Long jobExecutionId = chunkContext.getStepContext().getStepExecution().getJobExecution().getId();

        log.info("==========================================================================");
        log.info("RestartStep2Task: (" + result + "/" + jobInstanceId + "/" + jobExecutionId + ") owner >" + jobParameters.getString("owner") + ">>>>>" + result);
        log.info("==========================================================================");
        return RepeatStatus.FINISHED;
    }
}
