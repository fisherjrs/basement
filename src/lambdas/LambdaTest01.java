package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LambdaTest01 {
	
	public static Logger LOG = LoggerFactory.getLogger(LambdaTest01.class);
	
	public static void main(String[] args) {
		List<String> names = Arrays.asList("1", "2", "3");
		Stream<Object> lengths = names.stream().map(name -> name.length());
		LOG.debug(String.valueOf(lengths.count()));
	}
}