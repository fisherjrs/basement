package classes;

import java.util.Iterator;

public class DataStructure2 {
    
    // Create an array
    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];
    
    interface DataStructureIterator extends java.util.Iterator<Integer> { } 
   
    
    public DataStructure2() {    	
    	// fill the array with ascending integer values
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }
    
    public DataStructureIterator createIterator() {
    	 DataStructureIterator iterator = new EvenIterator();
    	 return iterator;
    }
    
    public void printEven() {
        
        // Print out values of even indices of the array
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
    
    public void print(DataStructureIterator iterator) {
    	while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
    
    public void print(java.util.function.Function<Integer, Boolean> function) {
    	 for (int i = 0; i < SIZE; i++) {
             if (function.apply(i)) {
                 System.out.print(arrayOfInts[i] + " ");
             }
         }
    }

    // Inner class implements the DataStructureIterator interface,
    // which extends the Iterator<Integer> interface
    
    private class EvenIterator implements DataStructureIterator {
        
        // Start stepping through the array from the beginning
        private int nextIndex = 0;
        
        public boolean hasNext() {
            
            // Check if the current element is the last in the array
            return (nextIndex <= SIZE - 1);
        }        
        
        public Integer next() {
            
            // Record a value of an even index of the array
            Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
            
            // Get the next even element
            nextIndex += 2;
            return retValue;
        }
    }
    
    public static void main(String s[]) {
        
    	int a = 1;
    	System.out.println(a << 0);
    	System.out.println(a << 1);
    	System.out.println(a << 2);
    	System.out.println(a << 3);
        // Fill the array with integer values and print out only
        // values of even indices
        DataStructure2 ds = new DataStructure2();
        ds.printEven(); 
        ds.print(ds.createIterator());
        /*
        ds.print(new DataStructureIterator() {
	        	private int nextIndex = 1;
	        	public boolean hasNext() {
	        		return (nextIndex < SIZE - 1);
	        	}
	        	
	        	public Integer next() {
	        		Integer retValue = Integer.valueOf(ds.arrayOfInts[nextIndex]);
	        		nextIndex += 2;
	        		return retValue;
	        	}
        	
        	});
        	*/
        ds.print(index -> {
            if (index % 3 == 0) return Boolean.TRUE;
            return Boolean.FALSE;
        });
    }
}