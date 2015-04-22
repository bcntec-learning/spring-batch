package houseware.learn.spring.springbatch.case06;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class DummyStepExecutionListener extends StepExecutionListenerSupport {

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
                + "read (count=" + stepExecution.getReadCount() + ", skip=" + stepExecution.getReadSkipCount() + ") "
                + "write(count=" + stepExecution.getWriteCount() + ", skip=" + stepExecution.getWriteSkipCount() + ") "
                + "process(skip=" + stepExecution.getProcessSkipCount() + ")"
                + "total (skip=" + stepExecution.getSkipCount() + ") ");
    }
}
