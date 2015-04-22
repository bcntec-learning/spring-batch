package houseware.learn.spring.springbatch.case04;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class ProductWriter implements ItemWriter<Product> {

    @Override
    public void write(List<? extends Product> items) throws Exception {
        for (Product item : items) {
            log.info("Product >>>" + item);
        }

    }
}
