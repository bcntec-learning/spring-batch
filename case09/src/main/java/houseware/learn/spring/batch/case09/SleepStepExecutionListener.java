package houseware.learn.spring.batch.case09;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class SleepStepExecutionListener extends StepExecutionListenerSupport {

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        ExitStatus exitStatus = super.afterStep(stepExecution);
        try {
            log.info("sleepping");
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        return exitStatus;
    }

}
