package houseware.learn.spring.batch.case03.test;

import houseware.learn.spring.batch.base.TestCaseBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
@ContextConfiguration(locations = "classpath:houseware/learn/spring/batch/case03/test/test-context.xml")
public class Case03NotebooksTest extends TestCaseBase {


    @Autowired
    private Job notebooksImportJob;
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void importNotebooks() throws Exception {

        Assert.assertEquals(BatchStatus.COMPLETED,
                getJobLauncher().run(notebooksImportJob, new JobParametersBuilder()
                        .addString("file", "classpath:/houseware/learn/spring/batch/case03/data/notebooks.txt")
                        .addString("exportResource", "./target/export.txt")
                        .addLong("timestamp", System.currentTimeMillis())
                        .toJobParameters()
        ).getStatus());
        int notebooks = 3;
        Assert.assertEquals(new Integer(notebooks), jdbcTemplate.queryForObject("select count(1) from products where type='NOTEBOOK'", Integer.class));
    }


}