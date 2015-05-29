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
		Optional<Integer> g = someNumbers.stream()
				.map(x -> x * x)
				.filter(x -> x % 3 == 0)
				.findFirst();
		LOG.debug("First integer squared divisible by 3:: {}", g.get());
	}
	
	public WorkingWithStreams() {
		// TODO Auto-generated constructor stub
	}

}
