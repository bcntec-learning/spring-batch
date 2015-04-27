package houseware.learn.spring.batch.case07;


import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.batch.item.file.FlatFileHeaderCallback;

import java.io.IOException;
import java.io.Writer;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
public class SimpleService  implements FlatFileHeaderCallback, FlatFileFooterCallback {

    @Override
    public void writeHeader(Writer writer) throws IOException {
        writer.write("# Files /bin :: BEGIN");
    }

    @Override
    public void writeFooter(Writer writer) throws IOException {
        writer.write("# Files /bin :: END");

    }

    public void simpleServiceMethod() throws IOException {
        log.info("creating test.txt");
        String[] cmd = {
        "/bin/sh",
        "-c",
        "ls /bin | sed /^total/d > /tmp/test.txt"
        };

        Runtime.getRuntime().exec(cmd);
    }

}
