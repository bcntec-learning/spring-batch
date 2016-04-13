package houseware.learn.spring.batch.case07.test;

import houseware.learn.spring.batch.base.TestCaseBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
@ContextConfiguration(locations = "classpath:houseware/learn/spring/batch/case07/test/test-context.xml")
public class DecisionTest extends TestCaseBase {


    @Autowired
    private Job decisionJob;


    @Test
    public void decision1Test() throws Exception {
        JobExecution exec = getJobLauncher().run(decisionJob, new JobParametersBuilder().addLong("param", 1L).toJobParameters());

        Assert.assertEquals(BatchStatus.COMPLETED, exec.getStatus());
    }

    @Test
    public void decision100Test() throws Exception {
        JobExecution exec = getJobLauncher().run(decisionJob, new JobParametersBuilder().addLong("param", 100L).toJobParameters());
        Assert.assertEquals(BatchStatus.FAILED, exec.getStatus());
    }

}