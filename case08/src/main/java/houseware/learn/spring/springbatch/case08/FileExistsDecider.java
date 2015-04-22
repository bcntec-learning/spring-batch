package houseware.learn.spring.springbatch.case08;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

/**
 * @author fphilip@houseware.es
 */
public class FileExistsDecider implements JobExecutionDecider {

    private BatchService batchService;


    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution,
                                      StepExecution stepExecution) {
        String targetFile = jobExecution.getJobParameters().getString("archiveFile");
        if (batchService.exists(targetFile)) {
            return new FlowExecutionStatus("FILE EXISTS");
        } else {
            return new FlowExecutionStatus("NO FILE");
        }
    }

    public void setBatchService(BatchService batchService) {
        this.batchService = batchService;
    }

}
