package houseware.learn.spring.batch.case03.test;

import houseware.learn.spring.batch.base.TestCaseBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author fphilip@houseware.es
 */

@ContextConfiguration(locations = "classpath:houseware/learn/spring/batch/case03/test/test-context.xml")
public class Case03XmlTest extends TestCaseBase {

    @Autowired
    private Job productXMLImport;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void xmlJob() throws Exception {
        Assert.assertEquals(BatchStatus.COMPLETED, jobLauncher.run(productXMLImport, new JobParameters()).getStatus());
        jdbcTemplate.queryForList("select name from products", String.class).forEach((string) -> {
        	System.out.println("<name>: " + string);
        });
    }


}
