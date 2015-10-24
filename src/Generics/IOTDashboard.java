package Generics;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IOTDashboard {

	private static Logger LOG = LoggerFactory.getLogger(IOTDashboard.class);
	
	public IOTDashboard() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
				
		LightSwitch lightSwitch = LightSwitch.getLightSwitch(
				new Double(35.99), 
				LocalDate.parse("2011-01-11")
			);
		
		LightSwitch phillipsLightSwitch = LightSwitch.getLightSwitch(				
				Double.valueOf("38.99"), 
				//Duration.between(LocalDate.parse("2015-01-15"), LocalDate.now())
				LocalDate.parse("2014-04-11")
			);
		
		Double lsValue = lightSwitch.calculateValue(lightSwitch.cost, lightSwitch.getInstallDate(), LocalDate.now());
		Double phillipsValue = lightSwitch.calculateValue(phillipsLightSwitch.cost, phillipsLightSwitch.getInstallDate(), LocalDate.now());
		
		LOG.debug(String.format("This value of a basic light switch is %s, the cost of phillips is %s", lsValue, phillipsValue));
	}

}
