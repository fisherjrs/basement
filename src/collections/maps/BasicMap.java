package collections.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import classes.Vagabond;

public class BasicMap {
	
	public static void main(String[] args) {
		Map<Integer, Long> map1 = new HashMap<Integer, Long>();
		map1.put(1, 456824L);
		map1.put(2, 556824L);
		map1.put(43, 656824L);
		map1.put(4, 756824L);
		map1.put(17, 856824L);
		map1.put(6, 956824L);
		
		//Loop method - use iterator
		Iterator iterator = map1.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<Integer, Long> pair = (Map.Entry<Integer, Long>) iterator.next();
			System.out.println(String.format("Map iteration: key:%4s value:%4s", pair.getKey(), pair.getValue()));
		}
		
		System.out.println("");
		//Preferred loop method - use for each
		for(Map.Entry<Integer, Long> entry : map1.entrySet()) {
			System.out.println(String.format("Map iteration: key:%4s value:%4s", entry.getKey(), entry.getValue()));
		}
		
		System.out.println("");
		
		Map<Integer, Vagabond> map2 = new HashMap<Integer, Vagabond>();
		map2.put(1, Vagabond.createVagabond("The Cosmos", "Wise man on top of mountain."));
		map2.put(2, Vagabond.createVagabond("Mexico", "Beach comber."));
		map2.put(3, Vagabond.createVagabond("The Lesser Antilles", "Spear fisher."));
		
		for(Map.Entry<Integer, Vagabond> entry : map2.entrySet()) {
			System.out.println(String.format("Map2 iteration: key:%4s value:%4s class:%4s hashcode:%4s", entry.getKey(), entry.getValue().getDestiny(), entry.getClass(), entry.hashCode()));
		}
		
		
	}
	
	public BasicMap() {
		
	}
}