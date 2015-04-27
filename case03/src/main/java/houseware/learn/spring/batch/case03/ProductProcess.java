package houseware.learn.spring.batch.case03;

import org.springframework.batch.item.ItemProcessor;

/**
 * @author fphilip@houseware.es
 */
public class ProductProcess implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product product) throws Exception {

        return product;

    }
}
