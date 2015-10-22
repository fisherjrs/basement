package katas;

public class StringFormatExample {

	//%[argument number] [flags] [width] [.precision] type
	public static void main(String[] args) {
		
		String s = String.format("%-12.5f%.20f", 12.23429837482,9.10212023134);
		
		System.out.println(s);
	}

}
