package houseware.learn.spring.springbatch.case06.test.basic;

import houseware.learn.spring.springbatch.base.TestCaseBase;
import org.junit.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author fphilip@houseware.es
 */
@ContextConfiguration(locations = "classpath:houseware/learn/spring/springbatch/case06/test/test-context.xml")
public class ListenersTest extends TestCaseBase {

    @Autowired
    private Job listenerJobsSkipLimitJob;


    @Autowired
    private Job listenerJobsSkipPolicyJob;


    @Test
    public void testSkipLimit() throws Exception {
        getJobLauncher().run(listenerJobsSkipLimitJob, new JobParameters());
    }

    @Test
    public void testSkipPolicyOk() throws Exception {
        getJobLauncher().run(listenerJobsSkipPolicyJob, new JobParameters());
    }
    @Test
    public void testSkipPolicyFatal() throws Exception {
        getJobLauncher().run(listenerJobsSkipPolicyJob, new JobParametersBuilder().addLong("fatal",66L).toJobParameters());
    }


}
