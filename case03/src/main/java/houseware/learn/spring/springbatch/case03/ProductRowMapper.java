package houseware.learn.spring.springbatch.case03;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author fphilip@houseware.es
 */
public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

        Product user = new Product();

		user.setId(rs.getString("id"));
		user.setType(rs.getString("type"));
		user.setName(rs.getString("name"));
		user.setDescription(rs.getString("description"));
		user.setPrice(rs.getBigDecimal("price"));

		return user;
	}

}
