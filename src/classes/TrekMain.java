package classes;

public class TrekMain {

	public TrekMain() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Trek trek = new Trek();
//Fail	Trek.Handlebars.grips = "45cm";						//Access the public static member of a private static nested class.
		Trek.Wheels.grips = "33cm";							//Access the public static member of a public static nested class.
		
//Fail	Trek.Handlebars hb99 = new Trek.Handlebars();		//Instantiate the private static nested class from outside
//Fail	hb99.size = "23cm"; 								//I can access a public property in a static nested class.
		
		Trek.Wheels w99 = new Trek.Wheels();				//Instantiate public static nested class from outside.
		w99.setOriginationP("Finland");						//Invoke public member on static nested class.
	}

}
