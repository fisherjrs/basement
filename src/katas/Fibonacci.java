package katas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Fibonacci {

    //F(n) = F(n-1) + F(n-2)
	public static int count = 0;
	
	public static void main(String[] args) {
		
		System.out.println(fibonacci(9));
		System.out.println(fibonacciDP(9));
		System.out.println(fibonacciDP2(70));
	}
	
	public Fibonacci() {
		
	}
	
	public static long fibonacci(int n) {
	    if (n < 3) return 1;

	    //Map to store the previous results
	    Map<Integer,Long> computedValues = new HashMap<Integer, Long>();
	    //The two edge cases
	    computedValues.put(1, 1L);
	    computedValues.put(2, 1L);

	    return fibonacci(n,computedValues);
	}

	private static long fibonacci(int n, Map<Integer, Long> computedValues) {
	    if (computedValues.containsKey(n)) return computedValues.get(n);

	    computedValues.put(n-1, fibonacci(n-1,computedValues));
	    computedValues.put(n-2, fibonacci(n-2,computedValues));

	    long newValue = computedValues.get(n-1) + computedValues.get(n-2);
	    computedValues.put(n, newValue);
	    return newValue;
	}
	
	public static long fibonacciDP(int n) {
	    long[] results = new long[n+2];
	    results[1] = 1;
	    results[2] = 1;
	    for(int i = 3; i<=n; i++) {
	    	results[i] = results[i-2] + results[i-1];
	    }
	    
	    return results[n];
	}
	
	public static long fibonacciDP2(int n) {
	    long n1 = 1;
	    long n2 = 1;
	    long current = 2;
		for(int i = 3; i<=n; i++) {
	    	current = n1 + n2;
	    	n2 = n1;
	    	n1 = current;
	    }
	    
	    return current;
	}

}
