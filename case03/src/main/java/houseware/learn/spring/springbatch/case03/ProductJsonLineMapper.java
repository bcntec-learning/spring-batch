package houseware.learn.spring.springbatch.case03;

import org.springframework.batch.item.file.LineMapper;

import java.math.BigDecimal;
import java.util.Map;

public class ProductJsonLineMapper implements LineMapper<Product> {
    private org.springframework.batch.item.file.mapping.JsonLineMapper delegate;

	public Product mapLine(String line, int lineNumber) throws Exception {
  		  Map<String,Object> productAsMap
  		                 = delegate.mapLine(line, lineNumber);

		Product product = new Product();
		product.setId((String)productAsMap.get("id"));
		product.setName((String)productAsMap.get("name"));
		product.setDescription((String)productAsMap.get("description"));
		product.setPrice(new BigDecimal((Double)productAsMap.get("price")));

		return product;
	}

	public void setDelegate(org.springframework.batch.item.file.mapping.JsonLineMapper delegate) {
		this.delegate = delegate;
	}
}
