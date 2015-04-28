package houseware.learn.spring.batch.case03;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DefaultFieldSet;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.batch.item.file.transform.PatternMatchingCompositeLineTokenizer;
import org.springframework.batch.support.PatternMatcher;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import java.util.Map;

/**
 *
 */
public class SpecialLineMapper<T>  implements LineMapper<T>, InitializingBean {


    private PatternMatchingCompositeLineTokenizer tokenizer = new PatternMatchingCompositeLineTokenizer();

    private PatternMatcher<FieldSetMapper<T>> patternMatcher;


    @Override
    public T mapLine(String line, int lineNumber) throws Exception {
        DefaultFieldSet z = (DefaultFieldSet) tokenizer.tokenize(line);

        return patternMatcher.match(line).mapFieldSet(
                 new DefaultFieldSet(
                         (String[])ArrayUtils.add(z.getValues(), String.valueOf(lineNumber)),
                         (String[])ArrayUtils.add(z.getNames(),"__idx__")
                 )


        );
    }



    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        this.tokenizer.afterPropertiesSet();
        Assert.isTrue(this.patternMatcher != null, "The 'fieldSetMappers' property must be non-empty");
    }

    public void setTokenizers(Map<String, LineTokenizer> tokenizers) {
        this.tokenizer.setTokenizers(tokenizers);
    }

    public void setFieldSetMappers(Map<String, FieldSetMapper<T>> fieldSetMappers) {
        Assert.isTrue(!fieldSetMappers.isEmpty(), "The 'fieldSetMappers' property must be non-empty");
        this.patternMatcher = new PatternMatcher<FieldSetMapper<T>>(fieldSetMappers);
    }
}
