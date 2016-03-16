package houseware.learn.spring.batch.base.test;

import houseware.learn.spring.batch.base.TestCaseBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author fphilip@houseware.es
 */
@ContextConfiguration(locations = "classpath:houseware/learn/spring/batch/base/test/test-context.xml")
public class BaseTest extends TestCaseBase {


    @Autowired
    private JobRepository jobRepository;


    @Test
    public void assertJobRepository() throws Exception {
        Assert.assertNotNull(jobRepository);
    }


}