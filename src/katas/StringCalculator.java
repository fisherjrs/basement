package katas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringCalculator {
	private final static Logger LOG = LoggerFactory.getLogger(StringCalculator.class);
	
	public static void main(String[] args) {
		LOG.debug("go.");
		LOG.debug("{}",StringCalculator.add(""));
	}
	
	public StringCalculator() {
		
	}
	
	public static final int add(final String numbers) {
		int returnValue = 0;
		String[] numbersArray = numbers.split(",");
		if(numbersArray.length > 2) {
			throw(new RuntimeException());
		} else {
			for(String number : numbersArray) {
				if(!number.isEmpty()) {
					returnValue += Integer.parseInt(number);
				}
			}
		}
		
		return returnValue;
	}
}