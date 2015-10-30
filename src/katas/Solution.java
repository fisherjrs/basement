package katas;

import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		
		Integer startingArea = 400 * 600;
		
		String s = "{\"0 292 399 307\", \"48 392 351 407\"}";
		
		String[] box = s.split(" ");
		Integer width = Math.abs(Integer.parseInt(box[2]) - Integer.parseInt(box[0]));
		Integer height = Math.abs(Integer.parseInt(box[3]) - Integer.parseInt(box[1]));
		
		startingArea = startingArea - (width * height);
		System.in.getClass();
		
		Integer area1 = 2344;
		Integer area2 = 3456;
		System.out.print(String.format("%2s %2s", startingArea, area2));
	}

}
