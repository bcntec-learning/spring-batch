package houseware.learn.spring.batch.case05;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author fphilip@houseware.es
 */
@Data
@ToString
@NoArgsConstructor
public class Dummy implements Serializable {
    @NotNull
    private String id;
    private String name;
    private String category;

    public Dummy(String id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }


}
