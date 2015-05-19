package utils;

public class BitShifter {

	public static void main(String [] args) {
		
		//Shifting left by N will result in the int being multiplied by 2 to the Nth power
		
		int a = 1;
    	System.out.println(a << 0);
    	System.out.println(a << 1);
    	System.out.println(a << 2);
    	System.out.println(a << 3);
    	
    	System.out.println(" ");
    	int a2 = 2;
    	System.out.println(a2 << 0);
    	System.out.println(a2 << 1);
    	System.out.println(a2 << 2);
    	System.out.println(a2 << 3);
    	
    	System.out.println(" ");
    	
    	//bit shift right n will result in int divided by n (except when n = 0)
    	int b = 1500;
    	System.out.println(b >> 0);
    	System.out.println(b >> 1);
    	System.out.println(b >> 2);
    	System.out.println(b >> 3);
    	
    	int b2 = 2000;
    	System.out.println(b2 >> 0);
    	System.out.println(b2 >> 1);
    	System.out.println(b2 >> 2);
    	System.out.println(b2 >> 3);
    	
    	System.out.println(1<<2 | 1<<3);
    	System.out.println(1<<2 ^ 1<<3);
    	System.out.println(700 | 8);
    	System.out.println(700 ^ 8);
	}
}
