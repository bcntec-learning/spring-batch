package houseware.learn.spring.batch.case07;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.LineMapper;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class PassThroughLineMapper implements LineMapper<String> {

    @Override
    public String mapLine(String line, int lineNumber) throws Exception {
        return  line;
    }
}
