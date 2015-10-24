package enums;

public class Basement99 {
	
	public static void main(String[] args) {
		Basement99.go();
		Basement43XS bsm = new Basement43XS();
	}
	
	public Basement99() {
		
	}
	
	private static void go() {
		System.out.println(String.format("%s", Bicycle.ROAD_BIKE));
		
		System.out.println(String.format("%s", Bicycle.pedalCount));
		System.out.println(String.format("%s", Bicycle.ROAD_BIKE.getPedalCount()));
		
		System.out.println(MessageUtil.getFormattedMessage("Go, Jimmy."));
		
		for(Bicycle bike:Bicycle.values()) {
			System.out.println(String.format("enum parts :: %s, %s, %s", bike.name(), bike.compareTo(Bicycle.DIRT_BIKE), bike.ordinal()));
		}
	}
}