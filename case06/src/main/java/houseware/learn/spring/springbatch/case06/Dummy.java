package houseware.learn.spring.springbatch.case06;

import javax.validation.constraints.NotNull;

/**
 * @author fphilip@houseware.es
 */
public class Dummy {
    private Long id;

    public Dummy(Long id) {
        this.id=id;
    }

    @NotNull
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Dummy{" +
                "id='" + id + '\'' +
                '}';
    }
}
