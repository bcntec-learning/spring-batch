package houseware.learn.spring.batch.case09.test;

import houseware.learn.spring.batch.base.TestCaseBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.batch.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;


/**
 * @author fphilip@houseware.es
 */

@ContextConfiguration(locations = "classpath:houseware/learn/spring/batch/case09/test/test-context.xml")
public class Case09PartitionerTest extends TestCaseBase {

    @Qualifier("partitionerJob")
    @Autowired
    private Job partitionerJob;


    @Test
    public void partitionerJob() throws Exception {
        Assert.assertEquals(BatchStatus.COMPLETED, runJob(partitionerJob).getStatus());
    }


    public JobExecution runJob(Job job) throws Exception {
        return jobLauncher.run(job, new JobParameters());
    }


}
