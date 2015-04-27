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
public class Case06RestartTest extends TestCaseBase {

    @Autowired
    private Job restartJob;


    @Test
    public void testRestartLaunch() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("owner", "Francisco")
                .toJobParameters();

        Assert.assertEquals(BatchStatus.FAILED, getJobLauncher().run(restartJob, jobParameters).getStatus());

        Assert.assertEquals(BatchStatus.FAILED, getJobLauncher().run(restartJob, jobParameters).getStatus());


        Assert.assertEquals(BatchStatus.FAILED, getJobLauncher().run(restartJob, jobParameters).getStatus());

        Assert.assertEquals(BatchStatus.FAILED, getJobLauncher().run(restartJob, jobParameters).getStatus());


        Assert.assertEquals(BatchStatus.COMPLETED, getJobLauncher().run(restartJob, jobParameters).getStatus());


    }


}
