package houseware.learn.spring.batch.case03;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 *
 */
@Slf4j
public class DiscriminatorItemWriter implements ItemWriter<Item> {
    @Override
    public void write(List<? extends Item> items) throws Exception {
        for (Item item : items) {
           log.info(item.toString());
        }

    }
}
