package Generics;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

interface IOTItem {
	
	void setCost(Double cost);
	BigDecimal getCost();
	
	void setInstallDate(LocalDate installDate);
	LocalDate getInstallDate();
	
	default BigDecimal calculateValue(BigDecimal cost, LocalDate startDate, LocalDate endDate) {
		long days = ChronoUnit.DAYS.between(startDate, endDate);
		System.out.println(days);
		System.out.println(cost);
		System.out.println(BigDecimal.valueOf(days));
		
		return BigDecimal.valueOf(days).divide(cost, 2, RoundingMode.UP);
	}
}