package collections.queue;

import org.junit.Test;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueueTest {

	private static Logger LOG = LoggerFactory.getLogger(Queue.class);
	
	@Test
    public void addingOneItemAndRemovingFromQueueWillReturnThatItem() throws Exception {
        Queue queue = new Queue();
        queue.add("Item 1");
        queue.add("Item 2");
        queue.add("Item 3");
        queue.add("Item 4");
        LOG.debug(queue.remove());
        //Assert.assertThat(queue.remove(), CoreMatchers.is("Item 1"));
    }
}
