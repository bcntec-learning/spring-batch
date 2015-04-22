package houseware.learn.spring.springbatch.case01.test;

import houseware.learn.spring.springbatch.base.TestCaseBase;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import org.slf4j.Logger;
/**
 * @author fphilip@houseware.es
 */
@ContextConfiguration(locations = "classpath:houseware/learn/spring/springbatch/base/test/test-context.xml")
public class BaseTest extends TestCaseBase {


    @Autowired
    private JobRepository jobRepository;


    @Test
    public void assertJobRepository() throws Exception {
        Assert.assertNotNull(jobRepository);
    }


}