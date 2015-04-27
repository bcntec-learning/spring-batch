package houseware.learn.spring.batch.case06;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.ChunkListenerSupport;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.scope.context.StepContext;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
public class DummyChunkListener extends ChunkListenerSupport {
    @Override
    public void afterChunk(ChunkContext context) {
        info("afterChunk", context);
    }

    @Override
    public void beforeChunk(ChunkContext context) {
        info("beforeChunk", context);
    }

    @Override
    public void afterChunkError(ChunkContext context) {
        info("afterChunkError", context);
    }

    private void info(String m, ChunkContext context) {
        StepContext stepContext = context.getStepContext();
        StepExecution stepExecution = stepContext.getStepExecution();
        log.info(DummyStepExecutionListener.info(m, stepExecution));
    }
}
