package houseware.learn.spring.batch.case06;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.scope.context.StepContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class Step1Task implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        StepContext stepContext = chunkContext.getStepContext();
        StepExecution stepExecution = stepContext.getStepExecution();
        JobExecution jobExecution = stepExecution.getJobExecution();
        JobInstance jobInstance = jobExecution.getJobInstance();
        ExecutionContext stepExecutionContext = stepExecution.getExecutionContext();

        Long jobInstanceId = jobInstance.getId();
        Long jobExecutionId = stepExecution.getJobExecutionId();

        int i = stepExecutionContext.getInt("idx", 0);

        if (i > 3) {
            jobExecution.getExecutionContext().putLong("result", i);
            return RepeatStatus.FINISHED;
        }

        JobParameters jobParameters = chunkContext.getStepContext().getStepExecution().getJobParameters();
        log.info("RestartStep1Task: (val=" + i + ", instance=" + jobInstanceId + ", exceuntion=" + jobExecutionId + ") owner >" + jobParameters.getString("owner") + ">>>>>" + i);
        stepExecutionContext.putInt("idx", ++i);
        throw new RuntimeException("idx=" + i);
    }
}
