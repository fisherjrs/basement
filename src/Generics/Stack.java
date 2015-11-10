package Generics;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> {
	
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public static void main (String[] args){
		Stack<String> stack = new Stack<String>();
		stack.push("fred");
		stack.push("Tommy");
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().toUpperCase());
		}
	}
	
	@SuppressWarnings("unchecked")
	public Stack() {
		//elements = new E[DEFAULT_INITIAL_CAPACITY]; // You can create an array of a reified type (arrays are reified, generics are erased).
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY]; //Cast the object array as type e. The array is stored in a private field and never returned to the client or passed to another method.
	}
	
	public void push(E e) {
		ensureCapcity();
		elements[size++] = e;
	}
	
	public E pop() {
		if(size == 0)
			throw new EmptyStackException();
		E result = elements[--size];
		elements[size] = null; //Eliminate obsolete reference.
		return result;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private void ensureCapcity() {
		if(elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
		
}
