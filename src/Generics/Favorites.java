package Generics;

import java.util.HashMap;
import java.util.Map;

/**
 * Consider typesafe hetergeneous containers.
 * 
 * typesafe - compile time type checking
 * hetergeneous - diverse in character or content
 * containers - structure content store - a dataset
 * 
 * @author fishej2
 *
 */
public class Favorites {

	public Favorites() {
		// TODO Auto-generated constructor stub
	}

	//Regular map with parameterized key/value pairs
	private Map<Integer, Long> map1 = 
			new HashMap<Integer, Long>();
	
	//A map with a generic key
	private Map<Class<?>, Object> favorites = 
			new HashMap<Class<?>, Object>();
	
	public <T> void putFavorite(Class<T> type, T instance) {
		if(type == null) {
			throw new NullPointerException("Type is null");
		}
		favorites.put(type,  instance);
	}
	
	public <T> T getFavorite(Class<T> type) {
		return type.cast(favorites.get(type));
	}
	
	
}
