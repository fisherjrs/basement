package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkingWithStreams {
	
	static final Logger LOG = LoggerFactory.getLogger(YearbookCustomerSearch.class);
	
	public static void main(String[] args) {
		List<Dish> menu = Dish.menu;
		List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);
		int sum = someNumbers.stream().reduce(0, (a,b) -> a + b);
		LOG.debug("sum {}", sum);
		
		int sum2 = someNumbers.stream().reduce(0, Integer::sum);
		LOG.debug("sum2 {}", sum2);
		
		int max = someNumbers.stream().reduce(0, (a,b) -> Integer.max(a,b));
		LOG.debug("max {}", max);
		
		
		//Find the longest string
		List<String> lines = Arrays.asList(
				"John Lennon wore really cool sunglasses.",
				"Tom Brady wins championships.",
				"Archie Starbunkle has diamonds on his heels."
				);
		
		Optional<Integer> listLength = lines.stream()
				.map(l -> l.length())
				.reduce((a,b) -> Integer.max(a,b));
		
		LOG.debug("length of string {}", listLength.get());
	}
	
	public WorkingWithStreams() {
		// TODO Auto-generated constructor stub
	}

}
