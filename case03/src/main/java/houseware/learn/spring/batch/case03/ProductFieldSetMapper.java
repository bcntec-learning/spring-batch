package houseware.learn.spring.batch.case03;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;


/**
 * @author fphilip@houseware.es
 */
public class ProductFieldSetMapper implements FieldSetMapper<Product> {

    /*
     * (non-Javadoc)
     * @see org.springframework.batch.item.file.mapping.FieldSetMapper#mapFieldSet(org.springframework.batch.item.file.transform.FieldSet)
     */
    public Product mapFieldSet(FieldSet fieldSet) throws BindException {
        Product product = new Product();
        product.setId(fieldSet.readString("ID"));
        product.setType(fieldSet.readString("TYPE"));
        product.setName(fieldSet.readString("NAME"));
        try {
            product.setDescription(fieldSet.readString("DESCRIPTION"));
        } catch (IllegalArgumentException e) {
        }
        product.setPrice(fieldSet.readBigDecimal("PRICE"));
        return product;
    }

}
