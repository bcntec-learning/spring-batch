package houseware.learn.spring.batch.case03;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;


/**
 * @author fphilip@houseware.es
 */
public class ItemTotalFieldSetMapper implements FieldSetMapper<ItemTotal> {

    /*
     * (non-Javadoc)
     * @see org.springframework.batch.item.file.mapping.FieldSetMapper#mapFieldSet(org.springframework.batch.item.file.transform.FieldSet)
     */
    public ItemTotal mapFieldSet(FieldSet fieldSet) throws BindException {
        ItemTotal total = new ItemTotal();
        total.setTotal(fieldSet.readLong("total"));
        total.setLine(fieldSet.readLong("__idx__"));
        return total;
    }

}
