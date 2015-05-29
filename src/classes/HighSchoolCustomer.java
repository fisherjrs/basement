package classes;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HighSchoolCustomer extends BaseCustomer {
	private static final Logger LOG = LoggerFactory.getLogger(HighSchoolCustomer.class);
	
	public static void main(String[] args) {
		LOG.debug("go");
		HighSchoolCustomer hs1 = new HighSchoolCustomer("Bickley HS");
		LOG.debug("hs1 guid:{}, value:{}", hs1.getGUID(), hs1.getEstimatedValue());
		
		HighSchoolCustomer hs2 = new HighSchoolCustomer("Farmington HS");
		LOG.debug("hs2 guid:{}, value:{}", hs2.getGUID(), hs2.getEstimatedValue());
	}
	
	public HighSchoolCustomer(String customerName) {
		super(customerName);
	}
	
	@Override
	public String generateGUID() {
		this.customerGUID = UUID.randomUUID().toString();
		return customerGUID;
	}
	
	@Override
	public Number getEstimatedValue() {
		Random random = new Random();
		int estimatedValue = random.nextInt(3000) + 1500;
		return estimatedValue;
	}
}