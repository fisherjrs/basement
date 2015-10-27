package classes;

public class Trek {

	public static String grips = "toplevelgrips";
	
	public Trek() {
		// TODO Auto-generated constructor stub
		Handlebars hb = new Handlebars();		//Instantiate the static nested class
		hb.size = "23cm"; 						//I can access a public property from the outer class.
		hb.substance = "bitunium";				//I can access a private member from the outer class.
		hb.setOrigination("Brazil"); 			//I can access a private member from the outer class.
		
	}
	
	public static void main(String[] args) {
		Trek trek = new Trek();
		Trek.Handlebars.grips = "45cm";						//Access the static member of the static nested class.
		
		Trek.Handlebars hb99 = new Trek.Handlebars();		//Instantiate the static nested class from outside
		hb99.size = "23cm"; 								//I can access a public property in a static nested class.
		
	}
	
	private static class Handlebars {
		public String size = "45cm";
		public static String grips = "nobby";
		private String substance = "kevlar";
		private String country = "";
		
		private void setOrigination(String country) {
			this.country = country;
		}
	}
	
	public static class Wheels {
		public String size = "45cm";
		public static String grips = "nobby";
		private String substance = "kevlar";
		private String country = "";
		
		private void setOrigination(String country) {
			this.country = country;
		}
		
		public void setOriginationP(String country) {
			this.country = country;
		}
	}
	
	public class Gears{
		public String size = "45cm";
		public static final String grips = "nobby";   //Must be final.
		private String substance = "kevlar";
		private String country = "";
		
		private void setOrigination(String country) {
			this.country = country;
		}
		
		public void setOriginationP(String country) {
			this.country = country;
		}
	}

}
