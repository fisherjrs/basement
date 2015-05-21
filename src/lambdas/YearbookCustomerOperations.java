package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YearbookCustomerOperations {
	private static Logger LOG = LoggerFactory.getLogger(YearbookCustomerOperations.class);
	
	public static void main(String[] args) {
		LOG.debug("Go.");
		List<YearbookCustomer> ybcList = new ArrayList<YearbookCustomer>();
		ybcList.add(new YearbookCustomer.Builder("Lake Harriet CS", 3).pageCount(230).studentCount(300).averageYearbookCost(75).salesrepName("Patti Smith").build());
		ybcList.add(new YearbookCustomer.Builder("Southwest HS", 3).pageCount(250).studentCount(150).averageYearbookCost(85).salesrepName("Greg TwoHower").build());
		ybcList.add(new YearbookCustomer.Builder("Washburn HS", 3).pageCount(120).studentCount(100).averageYearbookCost(95).salesrepName("Kristi Bellwether").build());
		ybcList.add(new YearbookCustomer.Builder("Olson MS", 3).pageCount(180).studentCount(200).averageYearbookCost(55).salesrepName("Pam Valdergaard").build());
		ybcList.add(new YearbookCustomer.Builder("Kenwood CS", 3).pageCount(300).studentCount(400).averageYearbookCost(45).salesrepName("Vince Melbourne").build());
		ybcList.add(new YearbookCustomer.Builder("Burroughs CS", 3).pageCount(295).studentCount(500).averageYearbookCost(125).salesrepName("Imogene Zanther").build());
		LOG.debug(ybcList.get(3).getCustomerName());
		
		Runnable r = () -> {System.out.println("go, green hornet");};
		r.run();
		
		List<YearbookCustomer> filteredList = process(ybcList, p -> p.getStudentCount() >= 200 && p.getStudentCount() <= 400);
		for(YearbookCustomer ybc : filteredList) {
			LOG.debug(ybc.getCustomerName() + " " + ybc.getStudentCount());
		}
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
	
}