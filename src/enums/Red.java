package enums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * An enum type is used to hold a fixed set of constants. Use them instead of int enum patterns which were used before enum types were introduced in 1.5. 
 * 
 * Characteristics and benefits:
 * 		Enum types are are effectively final because they have no accessible constructors. Clients can neither create instances of enum type nor extend them. They are generalized 
 * 		singletons.
 * 		Enums provide compile time type safety 
 */
public class Red {
	
	private static Logger LOG = LogManager.getLogger(Red.class);

	public enum Apple { FUJI, BRAEBURN, PIPPIN };
	public enum Regions { FUJI, BRAEBURN, PIPPIN };
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		
		LOG.debug(Day.FRIDAY);
		LOG.debug(Month.APRIL);
		if("FRIDAY".equals(Day.FRIDAY.toString())) {
			LOG.debug("go friday.");
		}
		
		if("friday".toUpperCase().equals(Day.FRIDAY.toString())){
			LOG.debug("still friday");
		}
		
		
		// Sample of Planet enum in common
		
		
		double earthWeight = Double.parseDouble((args.length == 0) ? "67" : args[0]);
		double mass = earthWeight / Planet.Earth.surfaceGravity();
		for (Planet p : Planet.values()) {
			LOG.info("Weight on {} is {}{}", p, Double.valueOf(p.surfaceWeight(mass)));
			LOG.info("You are {} of the {}", "king", "world");
		}
		
		/*
		
		//Sample of Operation enum in common... it has an abstract method
		System.out.printf("The result is %f, so stuff it.%n", Double.valueOf(Operation.PLUS.apply(23, 45)));
		System.out.printf("The result is %f, so stuff it.%n", Double.valueOf(Operation.MINUS.apply(23, 45)));
		System.out.printf("The result is %f, so stuff it.%n", Double.valueOf(Operation.TIMES.apply(23, 45)));
		System.out.printf("The result is %f, so stuff it.%n", Double.valueOf(Operation.DIVIDE.apply(23, 45)));
		
				
		Apple zz = Apple.FUJI;
		Apple bb = Apple.FUJI;
		
		if( zz == bb ) {
			System.out.println("Fuji is Braeburn ...??? ");
		}else{
			System.out.println("Fuji is not Braeburn!!!");
		}
		
		//Compare ordinal position
		System.out.println(zz.compareTo(bb));
		System.out.println(bb.compareTo(zz));
						
		
		//Enums have their own namespace 
		Apple yy = Apple.FUJI;
		Regions cc = Regions.FUJI;
		
		if(yy.equals(cc)) {
			System.out.println("Apple.Fuji is Region.Fuji ...??? ");
		}else{
			System.out.println("Fuji apple and Fuji region are not the same!!!");
		}
		
		if(cc.equals(Regions.FUJI)) {
			System.out.println("The enum instance is equal to the enum definition.");
		} else {
			System.out.println("No the instance is not equal to the definition");
		}
		
		System.out.println("hi :: " + cc.compareTo(Regions.FUJI));
		if(cc.compareTo(Regions.BRAEBURN) == 1) {
			System.out.println("The enum instance compares to the enum definition.");
		} else {
			System.out.println("No the instance doesn't compare to the definition");
		}
		
		*/
		
	}
}
