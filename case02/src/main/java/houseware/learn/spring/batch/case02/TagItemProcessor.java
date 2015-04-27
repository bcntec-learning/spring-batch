/**
 *
 */
package houseware.learn.spring.batch.case02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author fphilip@houseware.es
 */
public class TagItemProcessor implements ItemProcessor<String, String> {

    private static final Logger LOG = LoggerFactory.getLogger(TagItemProcessor.class);

    private TagService service;

    public TagItemProcessor(TagService service) {
        super();
        this.service = service;
    }

    /* (non-Javadoc)
     * @see org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
     */
    @Override
    public String process(String item) throws Exception {
        LOG.debug("processing " + item);
        String processed = service.processing(item);
        LOG.debug("after processing " + processed);
        return processed;
    }

}
