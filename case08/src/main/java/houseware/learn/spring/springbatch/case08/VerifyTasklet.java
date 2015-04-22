package houseware.learn.spring.springbatch.case08;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * @author fphilip@houseware.es
 */
public class VerifyTasklet implements Tasklet {

    private String outputDirectory;

    private BatchService batchService;

    private ImportMetadataHolder importMetadataHolder;


    @Override
    public RepeatStatus execute(StepContribution contribution,
                                ChunkContext chunkContext) throws Exception {
        batchService.verify(outputDirectory);
        importMetadataHolder.set(batchService.extractMetadata(outputDirectory));
        return RepeatStatus.FINISHED;
    }

    public void setBatchService(BatchService batchService) {
        this.batchService = batchService;
    }

    public void setOutputDirectory(String outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    public void setImportMetadataHolder(
            ImportMetadataHolder importMetadataHolder) {
        this.importMetadataHolder = importMetadataHolder;
    }

}
