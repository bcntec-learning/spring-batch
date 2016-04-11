package houseware.learn.spring.batch.case03;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 ** @author fphilip@houseware.es
 */
@ToString
@Getter
@Setter
public class ItemLine extends Item{
    private Long account;
    private String invoice;
}
