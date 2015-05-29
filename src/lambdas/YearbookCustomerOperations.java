package lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YearbookCustomerOperations {
	private static Logger LOG = LoggerFactory.getLogger(YearbookCustomerOperations.class);
	
	public static void main(String[] args) {
		LOG.debug("Go.");
		List<YearbookCustomer> ybcList = YearbookCustomer.createCustomerList();		
		
		//basic lamba for Runnable which is functional interface
		Runnable r = () -> {System.out.println("go, green hornet");};
		r.run();
		
		//Predicate
		List<YearbookCustomer> filteredList = process(ybcList, p -> p.getStudentCount() >= 200 && p.getStudentCount() <= 400);
		filteredList.forEach( u -> {LOG.debug(u.getCustomerName());});
		
		//Sorting
		Collections.sort(ybcList, (ybc1, ybc2) -> ybc1.getCustomerName().compareTo(ybc2.getCustomerName()));
		LOG.debug("");
		
		ybcList.forEach(u -> {LOG.debug(u.getCustomerName());});
		Collections.sort(ybcList, (ybc1, ybc2) -> ybc1.getSalesrepName().compareToIgnoreCase(ybc2.getSalesrepName()));
		LOG.debug("");
		
		Collections.sort(ybcList, (ybc1, ybc2) -> ybc2.getContractAmount().compareTo(ybc1.getContractAmount()));
		ybcList.forEach(u -> {LOG.debug(u.getCustomerName() + " :: " + u.getContractAmount());});
		
		
		//Function
		Integer totalTime = totalProcessingTime(ybcList, (ybc) -> (ybc.getStudentCount() / 2) * (ybc.getPageCount()/2));
		LOG.debug(String.valueOf(totalTime) + " minutes.");
	}
	
	public static List<YearbookCustomer> process(List<YearbookCustomer> ybcList, Predicate<YearbookCustomer> p) {
		List<YearbookCustomer> filteredList = new ArrayList<>();
		for(YearbookCustomer ybc : ybcList){
			if(p.test(ybc)) {
				filteredList.add(ybc);
			}
		}
		return filteredList;
	}
	
	public static Integer totalProcessingTime(List<YearbookCustomer> ybcList, Function<YearbookCustomer, Integer> func) {
		Integer processingTime = 0;
		for(YearbookCustomer ybc : ybcList) {
			processingTime += func.apply(ybc);
		}
		return processingTime;
	}

}