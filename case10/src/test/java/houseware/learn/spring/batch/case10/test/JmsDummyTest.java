/**
 *
 */
package houseware.learn.spring.batch.case10.test;

import houseware.learn.spring.batch.base.TestCaseBase;
import houseware.learn.spring.batch.case05.Dummy;
import org.junit.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * @author templth
 */
@ContextConfiguration(locations = "classpath:houseware/learn/spring/batch/case10/test/test-context.xml")
public class JmsDummyTest extends TestCaseBase {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Qualifier("jmsDummyJobs1")
    @Autowired
    private Job jmsDummyJobs1;
    @Qualifier("jmsDummyJobs2")
    @Autowired
    private Job jmsDummyJobs2;
    @Autowired
    protected JobLauncher jobAsyncLauncher;


    @Test
    public void test() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {

        getJobLauncher().run(jmsDummyJobs1, new JobParameters());


        sendDummyItem(new Dummy("M1", "one", "number"));
        sendDummyItem(new Dummy("M2", "two", "number"));
        sendDummyItem(new Dummy("M3", "three", "number"));
        sendDummyItem(new Dummy("M4", "four", "number"));
        sendDummyItem(new Dummy("M5", "five", "number"));
        sendDummyItem(new Dummy("M6", "six", "number"));
        sendDummyItem(new Dummy("M7", "seven", "number"));
        sendDummyItem(new Dummy("M8", "apple", "fruit"));
        sendDummyItem(new Dummy("M9", "melon", "fruit"));
        sendDummyItem(new Dummy("M10", "banana", "fruit"));

        getJobLauncher().run(jmsDummyJobs2, new JobParameters());
    }


    private void sendDummyItem(final Dummy item) {
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session)
                    throws JMSException {
                ObjectMessage message = session.createObjectMessage();
                message.setObject(item);
                return message;
            }
        });
    }


}
