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
public class DecisionParamDecider implements JobExecutionDecider {


    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {

        long param = jobExecution.getJobParameters().getLong("param");

        if (param < 10) {
            return new FlowExecutionStatus("OK");
        }
        return new FlowExecutionStatus("ERROR");
    }

}
