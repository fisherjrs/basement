package katas;

public class MyMergeSortAgain {
	
	 private int[] array;
	 private int[] tempMergArr;
	 private int length;

	public static void main(String[] args) {
		int[] inputArray = {45,23,11,89,77,98,4,28,65,43};
		MyMergeSortAgain mms = new MyMergeSortAgain();
		mms.sort(inputArray);
	}
	
	public void sort(int inputArray[]) {
		this.array = inputArray;
		this.length = inputArray.length;
		this.tempMergArr = new int[this.length];
		doMergeSort(0, this.length - 1);
	}
	
	private void doMergeSort(int lowerIndex, int higherIndex){
		
		if(lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex/2);
			doMergeSort(lowerIndex, middle);
			doMergeSort(middle + 1, higherIndex);
			mergeParts(lowerIndex, middle, higherIndex);
		}
	};
	
	private void mergeParts(int lowerIndex, int middle, int higherIndex){
	    
		System.out.println(String.format("Merge parts %4s %4s %4s", "lowerIndex", "middle", "higherIndex"));
		System.out.println(String.format("Merge parts %4s %4s %4s", lowerIndex, middle, higherIndex));  
		for (int i = lowerIndex; i <= higherIndex; i++) {
	           tempMergArr[i] = array[i];
	       }
	      
	       int i = lowerIndex;
	       int j = middle + 1;
	       int k = lowerIndex;
	       while (i <= middle && j <= higherIndex) {
	           if (tempMergArr[i] <= tempMergArr[j]) {
	               array[k] = tempMergArr[i];
	               i++;
	           } else {
	               array[k] = tempMergArr[j];
	               j++;
	           }
	           k++;
	       }
	       while (i <= middle) {
	           array[k] = tempMergArr[i];
	           k++;
	           i++;
	       }
	}
	
}