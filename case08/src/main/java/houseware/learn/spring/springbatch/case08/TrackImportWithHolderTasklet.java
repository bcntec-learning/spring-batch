package houseware.learn.spring.springbatch.case08;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * @author fphilip@houseware.es
 *
 */
public class TrackImportWithHolderTasklet implements Tasklet {
	
	private BatchService batchService;
	
	private ImportMetadataHolder importMetadataHolder;
	
	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		batchService.track(importMetadataHolder.get().getImportId());
		return RepeatStatus.FINISHED;
	}
	
	public void setBatchService(BatchService batchService) {
		this.batchService = batchService;
	}
	
	public void setImportMetadataHolder(
			ImportMetadataHolder importMetadataHolder) {
		this.importMetadataHolder = importMetadataHolder;
	}
}
