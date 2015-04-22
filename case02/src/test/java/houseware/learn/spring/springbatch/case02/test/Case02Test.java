package houseware.learn.spring.springbatch.case02.test;

import houseware.learn.spring.springbatch.base.TestCaseBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.slf4j.Logger;
/**
 * @author fphilip@houseware.es
 */

@Slf4j
@ContextConfiguration(locations = "classpath:houseware/learn/spring/springbatch/case02/test/test-context.xml")
public class Case02Test extends TestCaseBase {

    @Autowired
    private Job tagProcessJob;


    @Test
    public void testTagProcessJob() throws Exception {
        getJobLauncher().run(tagProcessJob, new JobParameters());
    }



}