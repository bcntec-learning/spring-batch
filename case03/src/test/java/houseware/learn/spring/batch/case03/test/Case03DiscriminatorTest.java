package houseware.learn.spring.batch.case03.test;

import houseware.learn.spring.batch.base.TestCaseBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author fphilip@houseware.es
 */

@ContextConfiguration(locations = "classpath:houseware/learn/spring/batch/case03/test/test-context.xml")
public class Case03DiscriminatorTest extends TestCaseBase {

    @Autowired
    private Job discriminatorJob;

    @Test
    public void disciminatorOkJob() throws Exception {
        Assert.assertEquals(BatchStatus.COMPLETED, jobLauncher.run(discriminatorJob,

                 new JobParametersBuilder()
                         .addString("resource","classpath:/houseware/learn/spring/batch/case03/data/discriminator-field.csv").toJobParameters()).getStatus());
    }

    @Test
    public void disciminatorErrorJob() throws Exception {
        Assert.assertEquals(BatchStatus.FAILED, jobLauncher.run(discriminatorJob,

                 new JobParametersBuilder()
                         .addString("resource","classpath:/houseware/learn/spring/batch/case03/data/discriminator-field-error.csv").toJobParameters()).getStatus());
    }


}
