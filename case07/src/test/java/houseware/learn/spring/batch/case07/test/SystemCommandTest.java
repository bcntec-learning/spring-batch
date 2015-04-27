package houseware.learn.spring.batch.case07.test;

import houseware.learn.spring.batch.base.TestCaseBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
@ContextConfiguration(locations = "classpath:houseware/learn/spring/batch/case07/test/test-context.xml")
public class SystemCommandTest extends TestCaseBase {


    @Autowired
    private Job systemCommandJob;


    @Test
    public void tmpFileTest() throws Exception {
        JobExecution exec = getJobLauncher().run(systemCommandJob,
                new JobParameters());

        Assert.assertEquals(BatchStatus.COMPLETED, exec.getStatus());

    }

}