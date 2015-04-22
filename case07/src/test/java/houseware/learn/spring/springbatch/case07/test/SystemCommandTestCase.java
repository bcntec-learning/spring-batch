package houseware.learn.spring.springbatch.case07.test;

import houseware.learn.spring.springbatch.base.TestCaseBase;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.slf4j.Logger;

/**
 * @author fphilip@houseware.es
 */
@ContextConfiguration(locations = "classpath:houseware/learn/spring/springbatch/case07/test/test-context.xml")
public class SystemCommandTestCase extends TestCaseBase {



     @Autowired
     private Job systemCommandJob;



   	@Test
    public void echoTest() throws Exception {
        getJobLauncher().run(systemCommandJob, new JobParametersBuilder().toJobParameters());
   	}



}