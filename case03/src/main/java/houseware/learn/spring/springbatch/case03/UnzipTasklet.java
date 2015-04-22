package houseware.learn.spring.springbatch.case03;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.Resource;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipInputStream;

/**
 * @author fphilip@houseware.es
 *
 */
public class UnzipTasklet implements Tasklet {
	
	private Resource inputResource;
	
	private String targetDirectory;
	
	private String targetFile;
	
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(inputResource.getInputStream()));

		
		File targetDirectoryAsFile = new File(targetDirectory);
		if(!targetDirectoryAsFile.exists()) {
			FileUtils.forceMkdir(targetDirectoryAsFile);
		}		
		
		File targetFile = new File(targetDirectory, this.targetFile);
		
		BufferedOutputStream bufferedOutputStream = null;
        while(zipInputStream.getNextEntry() != null) {
           if(!targetFile.exists()) {
        	   targetFile.createNewFile();
           }
           FileOutputStream fos = new FileOutputStream(targetFile);
           bufferedOutputStream = new BufferedOutputStream(fos);
           IOUtils.copy(zipInputStream, bufferedOutputStream);
           bufferedOutputStream.flush();
           bufferedOutputStream.close();
        }
        zipInputStream.close();
        
        if(!targetFile.exists()) {
        	throw new IllegalStateException("Could not unzip anything from the archive!");
        }
		
		return RepeatStatus.FINISHED;
	}
	
	public void setInputResource(Resource inputResource) {
		this.inputResource = inputResource;
	}
	
	public void setTargetDirectory(String targetDirectory) {
		this.targetDirectory = targetDirectory;
	}
	
	public void setTargetFile(String targetFile) {
		this.targetFile = targetFile;
	}
	
}
