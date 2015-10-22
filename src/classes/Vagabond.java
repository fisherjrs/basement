package classes;

public class Vagabond extends Traveler {
	
	public String era;
	String philosophy = "Jungian";
	
	public Vagabond(String origins, String destiny) {
		super();
		era = "Romantic Period";
		HumanBeing.getCommunicationMode();  //Static method defined on interface
		this.getTransportMode(); //Default instance method defined on interface
		this.getFarthestDistanceTraveled();
		this.setCountry("Canada");
		this.getCountry();
	}
	
	public Vagabond(String myera) {
		era = myera;
	}
	
	public void setEra(String myera) {
		this.era = myera;
	}
	
	public String getEra() {
		return era;
	}
	
	protected String getFarthestDistanceTraveled() {
		return "2500 miles";
	}
	
	public String getName(){return "Harry";};
	
	//No access modifier ... defaults to package private
	String getPhilosophy(){return this.philosophy;}
	
	 public static void methodThree(int i) {
	    }
}