/**
 *
 */
package houseware.learn.spring.batch.case02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class TagItemReader implements ItemReader<String> {


    private TagService service;

    public TagItemReader(TagService service) {
        super();
        this.service = service;
    }


    /* (non-Javadoc)
     * @see org.springframework.batch.item.ItemReader#read()
     */
    @Override
    public String read() throws Exception, UnexpectedInputException,
            ParseException {
        String read = service.reading();
        log.info("read " + read);
        return read;
    }

}
