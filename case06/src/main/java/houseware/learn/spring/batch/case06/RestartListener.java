package houseware.learn.spring.batch.case06;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class RestartListener implements StepExecutionListener {


    @Override
    public void beforeStep(StepExecution stepExecution) {
        JobParameters jobParameters = stepExecution.getJobParameters();

        Long result = stepExecution.getExecutionContext().containsKey("result") ? stepExecution.getExecutionContext().getLong("result") : null;
        log.info("--------------------------------------------------------------------------");
        log.info("Before Step " + stepExecution.getStepName() + " (" + stepExecution.getJobExecutionId() + "), result=" + result + ", owner=" + jobParameters.getString("owner"));

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {

        Long result = stepExecution.getExecutionContext().containsKey("result") ? stepExecution.getExecutionContext().getLong("result") : null;
        JobParameters jobParameters = stepExecution.getJobParameters();
        log.info("After Step " + stepExecution.getStepName() + " (" + stepExecution.getJobExecutionId() + "), result=" + result + ", owner=" + jobParameters.getString("owner"));
        log.info("--------------------------------------------------------------------------");
        return stepExecution.getExitStatus();
    }

}
