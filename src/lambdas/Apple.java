package lambdas;

import java.util.ArrayList;
import java.util.List;

public class Apple {
	
	public enum Variety {
		Braeburn, Honeycrisp, RedDelicious;
	}
	
	private int weight;
	private String color;
	private Variety variety;
	
	public Apple() {
		
	}
	
	public Apple(int weight, String color, Variety variety ) {
		this.weight = weight;
		this.color = color;
		this.variety = variety;
	}
	
	public static List<Apple> createInventory() {
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(new Apple(
				150, "Green", Variety.Honeycrisp
				));
		apples.add(new Apple(
				180, "Yellow", Variety.Braeburn
				));
		apples.add(new Apple(
				130, "Red", Variety.RedDelicious
				));
		
		return apples;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Variety getVariety() {
		return variety;
	}

	public void setVariety(Variety variety) {
		this.variety = variety;
	}
	
	
}