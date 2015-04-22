package houseware.learn.spring.springbatch.case08;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

/**
 * @author fphilip@houseware.es
 */
public class FileExistsStepListener implements StepExecutionListener {

    private BatchService batchService;

    private String targetFile;

    @Override
    public void beforeStep(StepExecution stepExecution) {
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        if (batchService.exists(targetFile)) {
            return new ExitStatus("FILE EXISTS");
        } else {
            return new ExitStatus("NO FILE");
        }
    }

    public void setBatchService(BatchService batchService) {
        this.batchService = batchService;
    }

    public void setTargetFile(String targetFile) {
        this.targetFile = targetFile;
    }

}
