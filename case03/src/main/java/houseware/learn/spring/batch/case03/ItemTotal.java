package houseware.learn.spring.batch.case03;

import lombok.Data;
import lombok.ToString;

/**
 ** @author fphilip@houseware.es
 */
@Data  @ToString
public class ItemTotal extends Item{
    Long total;
}
