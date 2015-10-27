package collections.trees;

public class Currency<T> implements Comparable<T> {

	private T storedValue;
	
	public Currency() {
		
	}
	
	public static <T> Currency<T> getCurrency(T value) {
		Currency<T> currency = new Currency<T>();
		return currency;
	}

	@Override
	public int compareTo(T otherCurrency) {
		int result = 0;
		
		//if(storedValue > (T) otherCurrency.)
		return 0;
	}

}
