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
public class Case03PhonesTest extends TestCaseBase {


    @Autowired
    private Job phoneImportJob;
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void importPhones() throws Exception {

        Assert.assertEquals(BatchStatus.COMPLETED,
                getJobLauncher().run(phoneImportJob, new JobParametersBuilder()
                        .addString("inputResource", "classpath:/houseware/learn/spring/batch/case03/data/phones.zip")
                        .addString("targetDirectory", "./target/import/")
                        .addString("targetFile", "phones.txt")
                        .addLong("timestamp", System.currentTimeMillis())
                        .toJobParameters()
        ).getStatus());
        Assert.assertEquals(new Integer(8), jdbcTemplate.queryForObject("select count(1) from products where type='PHONE' and id like 'PR-4%'", Integer.class));
    }


}