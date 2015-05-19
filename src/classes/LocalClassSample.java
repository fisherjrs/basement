package classes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalClassSample {
	
	private static Logger LOG = LoggerFactory.getLogger(LocalClassSample.class);
	
	static String regularExpression = "[^0-9]";
	
	public static void main(String[] args) {
		LOG.debug("go");
		validatePhoneNumber("701-232-5386", "345-6533");
	}
	
	public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {
		
		final int numberLength = 10;
		
		class PhoneNumber {
			String formattedPhoneNumber = null;
			PhoneNumber(String phoneNumber) {
				String currentNumber = phoneNumber.replaceAll(regularExpression, "");
				if(currentNumber.length() == numberLength) {
					formattedPhoneNumber = currentNumber;
				}else{
					formattedPhoneNumber = null;
				}
			}
			
			public String getNumber() {
				return formattedPhoneNumber;
			}
			
			public void printOriginalNumbers() {
				LOG.debug("Original numbers are " + phoneNumber1 + ' ' + phoneNumber2);
			}
		}	
		
		PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
		PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);
		    
	    myNumber1.printOriginalNumbers();
	    
        if (myNumber1.getNumber() == null) 
            LOG.debug("First number is invalid");
        else
        	LOG.debug("First number is " + myNumber1.getNumber());
        
        if (myNumber2.getNumber() == null)
        	LOG.debug("Second number is invalid");
        else
        	LOG.debug("Second number is " + myNumber2.getNumber());
	}
}