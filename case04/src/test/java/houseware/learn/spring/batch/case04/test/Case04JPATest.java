package houseware.learn.spring.batch.case04.test;

import houseware.learn.spring.batch.base.TestCaseBase;
import houseware.learn.spring.batch.case04.Airport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.test.context.ContextConfiguration;


/**
 * @author fphilip@houseware.es
 */

@ContextConfiguration(locations = "classpath:houseware/learn/spring/batch/case04/test/test-context.xml")
public class Case04JPATest extends TestCaseBase {

    @Qualifier("airportsJob")
    @Autowired
    private Job airportJob;

    @Qualifier("airportsPartitionJob")
    @Autowired
    private Job airportsPartitionJob;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    

    @Autowired
    private EntityManagerFactory entityManagerFactory;
    

    @Test
    public void simpleJpaJob() throws Exception {
        Assert.assertEquals(BatchStatus.COMPLETED, jobLauncher.run(airportJob, new JobParameters()).getStatus());
        
        jdbcTemplate.queryForList("select name from airports").forEach((string) -> {
        	System.out.println("<airport>: " + string);
        });
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Airport bcn = entityManager.find(Airport.class, "BCN");
        System.out.println("<Airport>: " + bcn.getIata()+" / "+bcn.getCity());
    }


}
