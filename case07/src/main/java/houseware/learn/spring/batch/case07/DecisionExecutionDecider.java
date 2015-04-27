package houseware.learn.spring.batch.case07;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class DecisionExecutionDecider implements JobExecutionDecider {


    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {

        long param = jobExecution.getJobParameters().getLong("param");
        long value = jobExecution.getExecutionContext().getLong("value");

        if ((value % 10) == param) {
            return new FlowExecutionStatus("OK");
        }
        return new FlowExecutionStatus("NONE");
    }

}
