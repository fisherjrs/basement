package lambdas;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YearbookCustomer {
	private static Logger LOG = LoggerFactory.getLogger(YearbookCustomer.class);
	
	private final Double contractAmount;
	private final Integer studentCount;
	private final Integer pageCount;
	private final int averageYearbookCost;
	private final String customerName;
	private final String salesrepName;
		
	public static class Builder {
		
		//Require parameters
		private final Double contractAmount;
		private final String customerName;
		
		//Optional parameters
		private Integer studentCount = 0;
		private Integer pageCount = 0;
		private int averageYearbookCost = 0;
		private String salesrepName = "";
	
		public static void main(String[] args) {
			new Builder("hig", Double.valueOf(3)).build();
		}
		
		public Builder(String customerName, Double contractAmount) {
			this.customerName = customerName;
			this.contractAmount = contractAmount;
		}
		
		public Builder studentCount(Integer count) {
			this.studentCount = count;
			return this;
		}
		
		public Builder pageCount(Integer count) {
			this.pageCount = count;
			return this;
		}
		
		public Builder averageYearbookCost(int cost) {
			this.averageYearbookCost = cost;
			return this;
		}
		
		public Builder salesrepName(String name) {
			this.salesrepName = name;
			return this;
		}
		
		public YearbookCustomer build() {
			return new YearbookCustomer(this);
		}
	}
	
	public static List<YearbookCustomer> createCustomerList() {
		List<YearbookCustomer> ybcList = new ArrayList<YearbookCustomer>();
		ybcList.add(new YearbookCustomer.Builder("Lake Harriet CS", Double.valueOf(12580)).pageCount(230).studentCount(300).averageYearbookCost(75).salesrepName("Patti Smith").build());
		ybcList.add(new YearbookCustomer.Builder("Southwest HS", Double.valueOf(14367)).pageCount(250).studentCount(150).averageYearbookCost(85).salesrepName("Greg TwoHower").build());
		ybcList.add(new YearbookCustomer.Builder("Washburn HS", Double.valueOf(22870)).pageCount(120).studentCount(100).averageYearbookCost(95).salesrepName("Kristi Bellwether").build());
		ybcList.add(new YearbookCustomer.Builder("Olson MS", 23454.23).pageCount(180).studentCount(200).averageYearbookCost(55).salesrepName("Pam Valdergaard").build());
		ybcList.add(new YearbookCustomer.Builder("Kenwood CS", 35876.00).pageCount(300).studentCount(400).averageYearbookCost(45).salesrepName("Vince Melbourne").build());
		ybcList.add(new YearbookCustomer.Builder("Burroughs CS", 18432.00).pageCount(295).studentCount(500).averageYearbookCost(125).salesrepName("Imogene Zanther").build());
		return ybcList;
	}
	
	private YearbookCustomer(Builder builder){
		this.averageYearbookCost = builder .averageYearbookCost;
		this.contractAmount = builder.contractAmount;
		this.customerName = builder.customerName;
		this.pageCount = builder.pageCount;
		this.salesrepName = builder.salesrepName;
		this.studentCount = builder.studentCount;
	}

	public Double getContractAmount() {
		return contractAmount;
	}

	public Integer getStudentCount() {
		return studentCount;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public int getAverageYearbookCost() {
		return averageYearbookCost;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getSalesrepName() {
		return salesrepName;
	}

}