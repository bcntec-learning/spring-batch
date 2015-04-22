package houseware.learn.spring.springbatch.case06;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.*;

import java.util.List;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class DummyItemWriter implements ItemWriter<Dummy> {
    private final static Logger logger = LoggerFactory.getLogger(DummyItemWriter.class);

    @Override
    public void write(List<? extends Dummy> dummies) throws Exception {
        for (Dummy dummy : dummies) {
            if(dummy.getId()==87){
                throw new DummyException("we don't want 87");
            }
            log.info("DummyItemWriter:" + dummy);
        }

    }
}
