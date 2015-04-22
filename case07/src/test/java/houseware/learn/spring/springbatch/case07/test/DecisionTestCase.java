package houseware.learn.spring.springbatch.case07.test;

import houseware.learn.spring.springbatch.base.TestCaseBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.slf4j.Logger;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
@ContextConfiguration(locations = "classpath:houseware/learn/spring/springbatch/case07/test/test-context.xml")
public class DecisionTestCase extends TestCaseBase {



    @Autowired
    private Job decisionJob;



  	@Test
   public void decision1Test() throws Exception {
       getJobLauncher().run(decisionJob, new JobParametersBuilder().addLong("param", 1L).toJobParameters());
  	}

  	@Test
   public void decision100Test() throws Exception {
       getJobLauncher().run(decisionJob, new JobParametersBuilder().addLong("param", 100L).toJobParameters());
  	}

}