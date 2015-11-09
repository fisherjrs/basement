package Generics;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class LightSwitch extends BaseIOTItem implements IOTItem {
	
	public static LightSwitch getLightSwitch(Double cost, LocalDate installDate) {
		LightSwitch lightSwitch = new LightSwitch();
		lightSwitch.cost = BigDecimal.valueOf(cost);
		lightSwitch.installDate = installDate;
		return lightSwitch;
	}
	
	public LightSwitch() {
		
	}
	
	@Override
	public void setCost(Double cost) {
		this.cost = BigDecimal.valueOf(cost);
	}

	@Override
	public BigDecimal getCost() {
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