package houseware.learn.spring.batch.case03;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;


/**
 * @author fphilip@houseware.es
 */
public class ItemLineFieldSetMapper implements FieldSetMapper<ItemLine> {

    /*
     * (non-Javadoc)
     * @see org.springframework.batch.item.file.mapping.FieldSetMapper#mapFieldSet(org.springframework.batch.item.file.transform.FieldSet)
     */
    public ItemLine mapFieldSet(FieldSet fieldSet) throws BindException {
        ItemLine itemLine = new ItemLine();
        itemLine.setAccount(fieldSet.readLong("account"));
        itemLine.setInvoice(fieldSet.readString("invoice"));
        itemLine.setLine(fieldSet.readLong("__idx__"));
        return itemLine;
    }

}
