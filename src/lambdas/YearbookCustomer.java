package lambdas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YearbookCustomer {
	private static Logger LOG = LoggerFactory.getLogger(YearbookCustomer.class);
	
	private final int contractAmount;
	private final int studentCount;
	private final int pageCount;
	private final int averageYearbookCost;
	private final String customerName;
	private final String salesrepName;
		
	public static class Builder {
		
		//Require parameters
		private final int contractAmount;
		private final String customerName;
		
		//Optional parameters
		private int studentCount = 0;
		private int pageCount = 0;
		private int averageYearbookCost = 0;
		private String salesrepName = "";
	
		public static void main(String[] args) {
			new Builder("hig", 3).build();
		}
		
		public Builder(String customerName, int contractAmount) {
			this.customerName = customerName;
			this.contractAmount = contractAmount;
		}
		
		public Builder studentCount(int count) {
			this.studentCount = count;
			return this;
		}
		
		public Builder pageCount(int count) {
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
	
	private YearbookCustomer(Builder builder){
		this.averageYearbookCost = builder .averageYearbookCost;
		this.contractAmount = builder.contractAmount;
		this.customerName = builder.customerName;
		this.pageCount = builder.pageCount;
		this.salesrepName = builder.salesrepName;
		this.studentCount = builder.studentCount;
	}

	public int getContractAmount() {
		return contractAmount;
	}

	public int getStudentCount() {
		return studentCount;
	}

	public int getPageCount() {
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