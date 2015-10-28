package classes;

public class Hobo extends Vagabond{

	String philosophy = "Jungian";
	
	public static void main(String[] args) {
		Hobo j = new Hobo("Industrial Revolution");
		System.out.println(j.getEra());
	}
	
	public Hobo() {
		super();
	}
	
	public Hobo( String myera) {
		super(myera);
	}
	
	protected String getFarthestDistanceTraveled() {
		return "2500 miles";
	}
	
	public String getName(){return "Harry";};
	
	//No access modifier ... defaults to package private
	String getPhilosophy(){return this.philosophy;}
	
}
