package utils;

import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ArraysUtil {

	public static Logger LOG = LogManager.getLogger(ArraysUtil.class);
	public static void main (String[] args){
		List<String> list = Arrays.asList("Mick", "Keith", "Charlie", "Ronnie");
		ArraysUtil autil = new ArraysUtil();
		autil.runHashCode(list);
		List<String> list2 = Arrays.asList("Mick", "Keith", "Charlie");
		autil.runHashCode(list2);
	}
	
	public void runHashCode(List<String> list) {
		LOG.debug(list.hashCode());
		
	}
}
