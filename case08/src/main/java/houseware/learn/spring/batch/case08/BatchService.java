package houseware.learn.spring.batch.case08;

import org.springframework.batch.core.JobExecution;

/**
 * @author fphilip@houseware.es
 */
public interface BatchService {

    void download(String targetFile);

    void decompress(String inputFile, String outputDirectory);

    void verify(String outputDirectory) throws IntegrityViolationException;

    void clean(String outputDirectory);

    void track(String importId);

    ImportMetadata extractMetadata(String outputDirectory);

    boolean exists(String file);

    void generateReport(JobExecution jobExecution);

}
