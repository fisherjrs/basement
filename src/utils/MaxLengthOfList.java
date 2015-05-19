package utils;

import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class MaxLengthOfList {

	public static Logger LOG = LoggerFactory.getLogger(MaxLengthOfList.class);
	
	public static void main (String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Buenos Aires");
		list.add("Córdoba");
		list.add("Las Cordavas Sur");
		list.add("La Plata");
		ArrayList<String> places = new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));
		
		Integer mi = new MaxLengthOfList().getMaxItemInList(places);
		LOG.debug(String.valueOf(mi));
	}
	
	public Integer getMaxItemInList(ArrayList<String> list) {
		Integer maxLength = Integer.valueOf(0);
		for( String item : list ) {
			LOG.debug(String.valueOf(item.length()));
			maxLength = (item.length() > maxLength)? item.length() : maxLength;
		}
		return maxLength;
	}
}