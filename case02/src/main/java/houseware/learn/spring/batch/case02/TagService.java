package houseware.learn.spring.batch.case02;

import lombok.extern.slf4j.Slf4j;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
public class TagService {
    String tags[] = new String[]{"A", "B", "C", "D", "E", "F"};
    int idx = 0;

    public String processing(String item) {

        log.info("TagService:processing:" + item);
        return item.toLowerCase();
    }

    public String reading() {

        return idx < tags.length ? tags[idx++] : null;
    }

    public void writing(String item) {
        log.info("TagService:writing:" + item);
    }
}
