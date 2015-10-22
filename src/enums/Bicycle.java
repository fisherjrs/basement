package enums;

public enum Bicycle implements BicycleParts {
	ROAD_BIKE, MOUNTAIN_BIKE, DIRT_BIKE, GENTLEMAN_BIKE, HYBRID;
	
	public Integer getPedalCount() {
		return this.pedalCount;
	}
}