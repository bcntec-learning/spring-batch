package houseware.learn.spring.springbatch.case08;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * @author fphilip@houseware.es
 */
public class CleanTasklet implements Tasklet {

    private BatchService batchService;

    private String outputDirectory;

    @Override
    public RepeatStatus execute(StepContribution contribution,
                                ChunkContext chunkContext) throws Exception {
        batchService.clean(outputDirectory);
        return RepeatStatus.FINISHED;
    }

    public void setBatchService(BatchService batchService) {
        this.batchService = batchService;
    }

    public void setOutputDirectory(String outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

}
