package classes;

public interface HumanBeing {
	
	String transportMode = "bipedal";
	String communicationMode = "verbal";
	
	void setEra(String myera);
	String getEra();
	
	default String getTransportMode(){
		return transportMode;
	};
	
	static String getCommunicationMode() {
		return communicationMode;
	}
}