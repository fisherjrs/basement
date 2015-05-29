package lambdas;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YearbookCustomerSearch{
	static final Logger LOG = LoggerFactory.getLogger(YearbookCustomerSearch.class);
	
	public static void main(String[] args) {
		List<YearbookCustomer> ybcList = YearbookCustomer.createCustomerList();
		
		boolean isProfitable = ybcList.stream().allMatch(c -> c.getContractAmount() > 100);
		LOG.debug("Are all the yearbooks profitable {}", (isProfitable)?"Yes": "No");
		
		boolean isNotFlagstaff = ybcList.stream().noneMatch(c -> "Flagstaff HS".equals(c.getCustomerName()));
		LOG.debug("isNotFlagstaff {}", isNotFlagstaff);
		
		
	}
}
