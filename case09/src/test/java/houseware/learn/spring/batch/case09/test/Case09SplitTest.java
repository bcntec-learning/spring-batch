package houseware.learn.spring.batch.case09.test;

import houseware.learn.spring.batch.base.TestCaseBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;


/**
 * @author fphilip@houseware.es
 */

@ContextConfiguration(locations = "classpath:houseware/learn/spring/batch/case09/test/test-context.xml")
public class Case09SplitTest extends TestCaseBase {

    @Qualifier("sliptImportJob")
    @Autowired
    private Job splitImportJob;

    @Qualifier("noSplitImportJob")
    @Autowired
    private Job noSplitImportJob;

    @Test
    public void nonSplitJob() throws Exception {
        Assert.assertEquals(BatchStatus.COMPLETED, runJob(noSplitImportJob).getStatus());
    }

    @Test
    public void slpitJob() throws Exception {
        Assert.assertEquals(BatchStatus.COMPLETED, runJob(splitImportJob).getStatus());
    }


    public JobExecution runJob(Job job) throws Exception {
        return jobLauncher.run(job, new JobParametersBuilder()
                .addString("inputResource", "classpath:/houseware/learn/spring/batch/case03/data/phones.zip")
                .addString("file", "classpath:/houseware/learn/spring/batch/case03/data/notebooks.txt")
                .addString("exportResource", "./target/export.txt")
                .addString("targetDirectory", "./target/import/")
                .addString("targetFile", "phones.txt")
                .addLong("timestamp", System.currentTimeMillis())
                .toJobParameters());
    }


}
