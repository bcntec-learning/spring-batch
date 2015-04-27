package houseware.learn.spring.batch.case01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.Map;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class ParametersTask implements Tasklet {


    @Override
    public RepeatStatus execute(StepContribution contribution,
                                ChunkContext chunkContext) throws Exception {
        JobParameters jobParameters = chunkContext.getStepContext().getStepExecution().getJobParameters();
        if (jobParameters.isEmpty()) {
            log.info("No job parameters!");
        } else {
            log.info("Job parameters:");
            for (Map.Entry<String, JobParameter> param : jobParameters.getParameters().entrySet()) {
                log.info(
                        String.format("%s = %s (%s)",
                                param.getKey(), param.getValue().getValue(), param.getValue().getType()
                        ));
            }
        }
        return RepeatStatus.FINISHED;
    }
}