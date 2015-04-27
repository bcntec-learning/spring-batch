package houseware.learn.spring.batch.case01.test;

import houseware.learn.spring.batch.base.TestCaseBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
@ContextConfiguration(locations = "classpath:houseware/learn/spring/batch/case01/test/test-context.xml")
public class Case01Test extends TestCaseBase {


    @Autowired
    private Job helloWorldJob;
    private JobParameters jobParameters = new JobParameters();

    @Autowired
    private Job parametersTaskJob;


    @Test
    public void testLaunchHelloWorldJob() throws Exception {
        getJobLauncher().run(helloWorldJob, jobParameters);
    }


    @Test
    public void testLaunchParameters() throws Exception {

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("user", "Francisco")
                .addDate("date", new Date())
                .toJobParameters();

        getJobLauncher().run(parametersTaskJob, jobParameters);
    }

}