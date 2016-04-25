package houseware.learn.spring.batch.case06;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.item.ItemProcessor;

import javax.annotation.Generated;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class DummyItemProcessor implements ItemProcessor<Dummy, Dummy> , ChunkListener {
    @Getter
    @Setter
    Long fatal = null;

    @Override
    public Dummy process(Dummy item) throws Exception {
        log.info("process:" + item);
        if (item.getId() == 71) {
            throw new DummyException("we can't write a 71");
        }
        if (item.getId().equals(fatal)) {
            throw new DummyException("fatal item " + fatal, true);
        }
        return item;
    }

    @Override
    public void beforeChunk(ChunkContext context) {
        fatal = (Long) context.getStepContext().getJobParameters().get("fatal");

    }

    @Override
    public void afterChunk(ChunkContext context) {

    }

    @Override
    public void afterChunkError(ChunkContext context) {

    }
}
