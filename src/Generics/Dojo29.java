package Generics;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;

public class Dojo29 {

	public static void main(String[] args) {
		Favorites favs = new Favorites();
		favs.putFavorite(String.class, "The Call of the Wild.");
		favs.putFavorite(Integer.class, 0xAABBCCAA);
		favs.putFavorite(Class.class, Favorites.class);
		
		String favoriteString = favs.getFavorite(String.class);
		Integer favoriteInteger = favs.getFavorite(Integer.class);
		Class<?> favoriteClass = favs.getFavorite(Class.class);
		
		System.out.printf("%s %x %s%n", favoriteString,
				favoriteInteger, favoriteClass.getName());    
		
		//List<Object> ol = new ArrayList<Long> (); //Incompatible types.
		//ol.add("I知 a string. I知 bad");
		
		//List<? extends Object> ol1 = new ArrayList<Long> (); //Compatible, but this seems bad ... it's a producer list, we should use super.
		//ol1.add("I知 a string. I知 bad");
		
		
	}
	
	public Dojo29() {
		// TODO Auto-generated constructor stub
	}
	
	
	interface Function {
		Object apply(Object arg0, Object arg2);
	}
	
	interface Function2<T> {
		T apply(T arg1, T arg2);
	}
	
	/**
	 * Bad example ... doesn't use generics and calls an alien method from a synchronized block.
	 * @param list
	 * @param f
	 * @param initVal
	 * @return
	 */
	static Object reduce(List list, Function f, Object initVal) {
		synchronized (list) {
			Object result = initVal;
			for(Object o : list) {
				result = f.apply(result, o);
				return result;
			}
		}
		
		return null;
	}

	//Thread safe, but without generics
	static Object reduce1(List list, Function f, Object initVal) {
		Object[] snapshot = list.toArray(); //locks list internally.
		Object result = initVal;
		for(Object o : snapshot) {
			result = f.apply(result, o);
		}
		return result;
	}

	/**
	 * Thread safe and using generics. However, it's still not typesafe.
	 * The type of E cannot be checked at runtime because the compiler doesn't know what type E is at runtime -- remember the type information is erased from generics.
	 * Casts to array of non-reifable type should only be used in special circumstances.
	 * 
	 * @param list
	 * @param f
	 * @param initVal
	 * @return
	 */
	
	static <E> E reduce2(List<E> list, Function2<E> f, E initVal) {
		E[] snapshot = (E[]) list.toArray(); //locks list internally.
		E result = initVal;
		for(E e : snapshot) {
			result = f.apply(result, e);
		}
		return result;
	}
	
	static <E> E reduce3(List<E> list, Function2<E> f, E initVal) {
		List<E> snapshot;
		synchronized(list) {
			snapshot = new ArrayList<E>(list);
		}
		E result = initVal;
		for(E e : snapshot) {
			result = f.apply(result, e);
		}
		return result;
	}
	
	
	
}
