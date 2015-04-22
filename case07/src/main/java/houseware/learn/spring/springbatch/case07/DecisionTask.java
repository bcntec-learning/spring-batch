package houseware.learn.spring.springbatch.case07;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.scope.context.StepContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.Date;

/**
 * @author fphilip@houseware.es
 */
public class DecisionTask implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        StepContext stepContext = chunkContext.getStepContext();
        StepExecution stepExecution = stepContext.getStepExecution();
        JobExecution jobExecution = stepExecution.getJobExecution();
        JobInstance jobInstance = jobExecution.getJobInstance();
        ExecutionContext stepExecutionContext = stepExecution.getExecutionContext();

        Long jobInstanceId = jobInstance.getId();
        Long jobExecutionId = stepExecution.getJobExecutionId();
        long value = new Date().getTime() % 10000;
        jobExecution.getExecutionContext().putLong("value", value);


        return RepeatStatus.FINISHED;

    }
}
