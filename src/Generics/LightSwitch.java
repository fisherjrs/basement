package Generics;

import java.time.LocalDate;
import java.time.Period;

public class LightSwitch extends BaseIOTItem implements IOTItem {
	
	public static LightSwitch getLightSwitch(Double cost, LocalDate installDate) {
		LightSwitch lightSwitch = new LightSwitch();
		lightSwitch.cost = cost;
		lightSwitch.installDate = installDate;
		return lightSwitch;
	}
	
	public LightSwitch() {
		
	}
	
	@Override
	public void setCost(Double cost) {
		this.cost = cost;
	}

	@Override
	public Double getCost() {
		return this.cost;
	}

	@Override
	public void setInstallDate(LocalDate installDate) {
		this.installDate = installDate;
	}

	@Override
	public LocalDate getInstallDate() {
		return this.installDate;
	}
}