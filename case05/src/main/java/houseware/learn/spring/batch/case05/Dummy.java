package houseware.learn.spring.batch.case05;

import javax.validation.constraints.NotNull;

/**
 * @author fphilip@houseware.es
 */
public class Dummy {
    private String id;
    private String name;
    private String category;

    public Dummy(String id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    @NotNull
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Dummy{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
