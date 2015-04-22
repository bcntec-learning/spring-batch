package houseware.learn.spring.springbatch.case03.test;

import houseware.learn.spring.springbatch.base.TestCaseBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

import org.slf4j.Logger;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
@ContextConfiguration(locations = "classpath:houseware/learn/spring/springbatch/case03/test/test-context.xml")
public class Case03PhonesTest extends TestCaseBase {


    @Autowired
    private Job phoneImportJob;
    @Autowired
   	private JdbcTemplate jdbcTemplate;




   	@Test public void importPhones() throws Exception {
   		int initial = jdbcTemplate.queryForObject("select count(1) from products where type='PHONE'", Integer.class);

   		getJobLauncher().run(phoneImportJob, new JobParametersBuilder()
   			.addString("inputResource", "classpath:/data/phones.zip")
   			.addString("targetDirectory", "./target/import/")
   			.addString("targetFile", "phones.txt")
   			.addLong("timestamp", System.currentTimeMillis())
   			.toJobParameters()
   		);
   		int phones = 4;
   		Assert.assertEquals(new Integer(initial + phones), jdbcTemplate.queryForObject("select count(1) from products where type='PHONE'", Integer.class));
   	}



}