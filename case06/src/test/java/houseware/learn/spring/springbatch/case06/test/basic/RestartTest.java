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
public class RestartTest extends TestCaseBase {

    @Autowired
    private Job restartJob;



    @Test
    public void testRestartLaunch() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
        				.addString("owner", "Francisco")
        				.toJobParameters();
        getJobLauncher().run(restartJob, jobParameters);


        getJobLauncher().run(restartJob, jobParameters);


        getJobLauncher().run(restartJob, jobParameters);

        getJobLauncher().run(restartJob, jobParameters);


        getJobLauncher().run(restartJob, jobParameters);



//        getJobLauncher().run(restartJob, jobParameters);
    }



}
