package reflection;

import java.time.LocalDate;

import Generics.LightSwitch;

public class DojoRunnerBlue {

	public DojoRunnerBlue() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		LightSwitch ls = new LightSwitch();
		ls.setCost(34.55);
		ls.setInstallDate(LocalDate.now());
		
		System.out.println(ls.getClass());
		
		if(System.console() != null) {
			Class c = System.console().getClass();
		}
	}

}
