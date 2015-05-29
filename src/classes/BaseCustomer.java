package classes;

public abstract class BaseCustomer{
	
	protected final String customerName;
	protected String customerGUID;
		
	public BaseCustomer(String customerName) {
		this.customerName = customerName;
		this.customerGUID = generateGUID();
	}
	
	abstract String generateGUID();
	abstract Number getEstimatedValue();
	
	public String getGUID() {
		return customerGUID;
	}
	
}