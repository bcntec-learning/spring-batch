package houseware.learn.spring.batch.case03;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 *
 */
@Slf4j
public class DiscriminatorItemProcessor implements ItemProcessor<Item, Item> {

    @Override
    public Item process(Item item) throws Exception {
        if(item instanceof ItemTotal){
            ItemTotal itemTotal = (ItemTotal) item;
            if(!itemTotal.getTotal().equals(item.getLine())){
                throw new Exception("no equals total");
            }
            return null;
        }

        return item;
    }
}
