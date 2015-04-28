package houseware.learn.spring.batch.case09;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author fphilip@houseware.es
 */
@AllArgsConstructor
@NoArgsConstructor
@Data @ToString
public class PartitionerItem {

    private Long id;
    private Date timestamp;

    public PartitionerItem(Long id){
        this.id=id;
    }


}
