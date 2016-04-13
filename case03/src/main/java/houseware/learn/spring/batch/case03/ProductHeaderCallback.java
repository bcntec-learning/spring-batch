package houseware.learn.spring.batch.case03;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

public class ProductHeaderCallback implements FlatFileHeaderCallback{

	@Override
	public void writeHeader(Writer writer) throws IOException {
		// TODO Auto-generated method stub
		writer.write("hola grabo lo que quiero");
	}

}
