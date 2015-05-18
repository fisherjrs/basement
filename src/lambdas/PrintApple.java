package lambdas;

import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class PrintApple {
	private static Logger LOG = LogManager.getLogger(PrintApple.class);
	
	interface ApplePredicate {
		boolean test(Apple apple);
	}

	
	public static void prettyPrintApple(List<Apple> apples, ApplePredicate p){
		for(Apple apple : apples){
			if(p.test(apple)){
				LOG.debug(apple.getVariety().toString());
			}
		}
	}
	
	
	public static void main(String[] args) {
		LOG.debug("Go");
		
		List<Apple> inventory = Apple.createInventory();
		
		prettyPrintApple(inventory, new ApplePredicate(){
			public boolean test(Apple apple){
				return (apple.getColor() == "Red"); 
			}
		});
		
		prettyPrintApple(inventory, (Apple a) -> a.getWeight() > 140);
	}
	
}