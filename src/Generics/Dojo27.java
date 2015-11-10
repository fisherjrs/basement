package Generics;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Dojo27 {
	
	public static void main(String[] args){
		Set<String> guys = new HashSet<String>(
				Arrays.asList("Tom", "Fred", "Walter"));
		Set<String> stooges = new HashSet<String>(
				Arrays.asList("Larry", "Moe", "Curly"));
		Set<String> aflCio = union(guys, stooges);
		System.out.println(aflCio);
		
		String[] strings = {"jute", "hemp", "nylon"};
		UnaryFunction<String> sameString = identityFunction();
		for(String s : strings) 
			System.out.println(sameString.apply(s));
		
	}
	
	public Dojo27() {
		
	}
	
	/*
	 * Uses raw types - don't do this, use generic methods.
	public static Set union(Set s1, Set s2) {
		Set result = new HashSet(s1);
		result.add(s2);
		return result;
	}
	*/
	
	public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
		Set<E> result = new HashSet<E>(s1);
		result.addAll(s2);
		return result;
	}
	
	public interface UnaryFunction<T> {
		T apply(T arg);
	}
	
	private static UnaryFunction<Object> IDENTITY_FUNCTION = 
			new UnaryFunction<Object>() {
				public Object apply(Object arg) { return arg; }
				};
	
	@SuppressWarnings("unchecked")
	public static <T> UnaryFunction<T> identityFunction() {
		return (UnaryFunction<T>) IDENTITY_FUNCTION;
	}
	
}