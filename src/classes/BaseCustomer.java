package classes;

public abstract class BaseCustomer{
	
	//protected final String customerName; //This creates a problem. Extending BaseCustomer will require an argument constructor... any subclass 
	//will need to have an argument constructor. 
	protected String customerName;
	protected String customerGUID;
		
	public BaseCustomer() {
	}
	
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