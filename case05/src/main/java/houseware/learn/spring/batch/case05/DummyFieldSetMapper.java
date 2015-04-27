package houseware.learn.spring.batch.case05;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;


/**
 * @author fphilip@houseware.es
 */
public class DummyFieldSetMapper implements FieldSetMapper<Dummy> {

    public Dummy mapFieldSet(FieldSet fieldSet) throws BindException {
        return new Dummy(fieldSet.readString("ID"), fieldSet.readString("NAME"), fieldSet.readString("CATEGORY"));
    }

}
