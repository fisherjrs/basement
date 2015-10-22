package classes;

public abstract class Traveler  implements HumanBeing{
	
	private String country;
	
	public Traveler(){
		
	}
	
	protected abstract String getFarthestDistanceTraveled();
	
	protected String getCountry() {
		return "Canada";
	}
	
	protected void setCountry(String country) {
		this.country = country;
	}
}