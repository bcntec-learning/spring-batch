

package houseware.learn.spring.batch.case09;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
public class CustomPartitioner implements Partitioner {

	public static final String PARTITION_KEY = "partition";

	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {
		Map<String, ExecutionContext> map = new HashMap<String, ExecutionContext>(gridSize);
		for (int i = 0; i < gridSize; i++) {
			ExecutionContext e = new ExecutionContext();
			e.putString(PARTITION_KEY, PARTITION_KEY+"-"+i);
			map.put(PARTITION_KEY + i, e);
		}
		return map;
	}

}
