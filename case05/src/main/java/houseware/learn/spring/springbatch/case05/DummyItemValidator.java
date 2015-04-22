package houseware.learn.spring.springbatch.case05;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;

/**
 * @author fphilip@houseware.es
 */
public class DummyItemValidator implements Validator<Dummy> {
    @Override
    public void validate(Dummy dummy) throws ValidationException {
        if (dummy.getCategory() == null || dummy.getCategory().trim().length()<1) {
            throw new ValidationException("Category is mandatory !");
        }
    }
}
