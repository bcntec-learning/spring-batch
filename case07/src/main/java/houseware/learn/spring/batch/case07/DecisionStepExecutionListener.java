package houseware.learn.spring.batch.case07;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class DecisionStepExecutionListener extends StepExecutionListenerSupport {

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        ExitStatus exitStatus = super.afterStep(stepExecution);
        info("afterStep (exitStatus=" + exitStatus + ")", stepExecution);
        return exitStatus;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        print("beforeStep", stepExecution);
        super.beforeStep(stepExecution);
    }

    private void print(String m, StepExecution stepExecution) {
        log.info(info(m, stepExecution));
    }

    public static String info(String m, StepExecution stepExecution) {
        return (m + ":" + stepExecution.getId() + ">" + m + ":"
                + "value =" + (stepExecution.getJobExecution().getExecutionContext().containsKey("value") ? stepExecution.getJobExecution().getExecutionContext().get("value") : null)
                + ", param=" + stepExecution.getJobExecution().getJobParameters().getParameters().get("param"));
    }
}
