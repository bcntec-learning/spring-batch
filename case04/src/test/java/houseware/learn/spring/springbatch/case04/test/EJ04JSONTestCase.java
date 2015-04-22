package houseware.learn.spring.springbatch.case04.test;

import houseware.learn.spring.springbatch.base.TestCaseBase;
import org.junit.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


/**
 * @author fphilip@houseware.es
 *
 */

@ContextConfiguration(locations = "classpath:houseware/learn/spring/springbatch/case04/test/test-context.xml")
public class EJ04JSONTestCase extends TestCaseBase {

    @Autowired
    private Job productJSONImport;

    @Test
    public void jsonJob() throws Exception {
        jobLauncher.run(productJSONImport, new JobParameters());
    }


}
