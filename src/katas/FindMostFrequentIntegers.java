package katas;

import java.util.ArrayList;
import java.util.List;

public class FindMostFrequentIntegers {
	
	public static void main (String[] args) {
		
		int[] ints = {2,3,6,55,3,5,77,77,22,88,5,3,1,2,99,88,88,88};
		//int[] ints = {2,3,6};
		int maxCount = 1;
		List<Integer> winners = new ArrayList<Integer>();
		for(int i:ints){
			int currentCount = 0;
			for(int j:ints) {
				if(i==j){
					currentCount++;
				}
			}
			if(currentCount > maxCount) {
				maxCount = currentCount;
				winners.add(Integer.valueOf(i));				
			}
		}
		if( winners.isEmpty()){
			System.out.println("All integers appear 1 time.");
		}else{
			//%[argument number] [flags] [width] [.precision] type
			System.out.println(String.format("The numbers that appear the most times are: %s. They appear %d times.", winners.toString(), maxCount));
		}
	}
}