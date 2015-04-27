/**
 *
 */
package houseware.learn.spring.batch.case02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class TagItemWriter implements ItemWriter<String> {


    private TagService service;

    public TagItemWriter(TagService service) {
        super();
        this.service = service;
    }

    @Override
    public void write(List<? extends String> items) throws Exception {
        log.info("write");
        for (String item : items) {
            log.info("item:" + item);
            service.writing(item);
        }
    }

}
