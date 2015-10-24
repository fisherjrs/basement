package Generics;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

interface IOTItem {
	
	void setCost(Double cost);
	Double getCost();
	
	void setInstallDate(LocalDate installDate);
	LocalDate getInstallDate();
	
	default Double calculateValue(Double cost, LocalDate startDate, LocalDate endDate) {
		long days = ChronoUnit.DAYS.between(startDate, endDate);
		return days/cost;
	}
}