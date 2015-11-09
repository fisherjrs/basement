package language.math;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DojoBigDecimal {

	public static void main (String[] args) {
		BigDecimal dec1 = BigDecimal.valueOf(10.341);
		BigDecimal dec3 = BigDecimal.valueOf(10.349);
		System.out.println(dec1);
		
		BigDecimal dec2 = BigDecimal.valueOf(-11.34567);
		System.out.println(dec2.abs());
		
		System.out.println(dec2.add(BigDecimal.valueOf(34.12)));
		System.out.println(dec1.add(dec3));
		
		
		System.out.println(BigDecimal.valueOf(45L, 1));
		
		
		
		DecimalFormat dformat = new DecimalFormat();
		
		System.out.println(String.format("decimal :: %f", dec1));
	}
	
	public DojoBigDecimal() {
		// TODO Auto-generated constructor stub
	}

}
