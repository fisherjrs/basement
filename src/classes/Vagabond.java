package classes;

public class Vagabond extends Traveler {
	
	private String era;
	private String philosophy;
	private String origins;
	private String destiny;
	
	public Vagabond() {
		super();
	}
	
	public static Vagabond createVagabond() {
		Vagabond v = new Vagabond();
		return v;
	}

	public static Vagabond createVagabond(String origins, String destiny) {
		Vagabond v = new Vagabond();
		v.setOrigins(origins);
		v.setDestiny(destiny);
		return v;
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
	
	public String getOrigins() {
		return origins;
	}

	public void setOrigins(String origins) {
		this.origins = origins;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	public void setPhilosophy(String philosophy) {
		this.philosophy = philosophy;
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