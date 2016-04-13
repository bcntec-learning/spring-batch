package houseware.learn.spring.batch.case03;

import org.springframework.batch.item.file.transform.FieldExtractor;

public class ProductFieldExtractor implements FieldExtractor<Product> {

	@Override
	public Object[] extract(Product item) {
		// TODO Auto-generated method stub
		return new Object[]{
				item.getId(), item.getName(),"HOLA"
		};
	}

}
