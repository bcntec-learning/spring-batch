package houseware.learn.spring.batch.case03;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
public class EnhancedProductJdbcItemWriter implements ItemWriter<Product> {

    private static final String INSERT_PRODUCT = "insert into products (id,type,name,description,price) values(?,?,?,?,?)";

    private static final String UPDATE_PRODUCT = "update products set type=?, name=?, description=?, price=? where id = ?";

    private JdbcTemplate jdbcTemplate;

    public EnhancedProductJdbcItemWriter(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* (non-Javadoc)
     * @see org.springframework.batch.item.ItemWriter#write(java.util.List)
     */
    public void write(List<? extends Product> items) throws Exception {

        log.info("EnhancedProductJdbcItemWriter "+items.size());
        for (Product item : items) {
            int updated = jdbcTemplate.update(UPDATE_PRODUCT,
                    item.getType(), item.getName(), item.getDescription(), item.getPrice(), item.getId()
            );
            if (updated == 0) {
                jdbcTemplate.update(
                        INSERT_PRODUCT,
                        item.getId(), item.getType(), item.getName(), item.getDescription(), item.getPrice()
                );
                log.info("INSERTED "+item.getName());
            }else {

                log.info("UPDATED "+item.getName());
            }
        }
    }

}
