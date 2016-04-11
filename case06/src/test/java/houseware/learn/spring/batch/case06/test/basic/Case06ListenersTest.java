package houseware.learn.spring.batch.case06.test.basic;

import houseware.learn.spring.batch.base.TestCaseBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.batch.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author fphilip@houseware.es
 */
@ContextConfiguration(locations = "classpath:houseware/learn/spring/batch/case06/test/test-context.xml")
public class Case06ListenersTest extends TestCaseBase {

    @Autowired
    private Job listenerJobsSkipLimitJob;


    @Autowired
    private Job listenerJobsSkipPolicyJob;


    @Test
    public void testSkipLimit() throws Exception {
        JobExecution exec = getJobLauncher().run(listenerJobsSkipLimitJob, new JobParameters());

        Assert.assertEquals(BatchStatus.COMPLETED, exec.getStatus());
    }

    @Test
    public void testSkipPolicyOk() throws Exception {
        JobExecution exec = getJobLauncher().run(listenerJobsSkipPolicyJob, new JobParameters());
        Assert.assertEquals(BatchStatus.COMPLETED, exec.getStatus());
    }

    @Test
    public void testSkipPolicyFatal() throws Exception {
        JobExecution exec = getJobLauncher().run(listenerJobsSkipPolicyJob,
        		new JobParametersBuilder().addLong("fatal", 75L)
        		.toJobParameters());

        Assert.assertEquals(BatchStatus.FAILED, exec.getStatus());
    }


}
