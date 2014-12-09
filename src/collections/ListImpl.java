package collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import enums.Planet;
import enums.Red.Apple;

/**
 * List is an interface that extends Collection. It is an ordered collection, also called a sequence. 
 * Elements can be inserted at specified locations and can be accessed by their integer position in the index.
 * Lists are also searchable, but that might involve a performance hit. The searches may be linear.
 * 
 * Lists allow duplicates (main differentiator from Sets)
 * Lists allow nulls (multiple nulls)
 * List contracts for iterator, add, remove, equals and hashcode have addtional stipulations beyond Collections interface
 * Has a special ListIterator that allows element insertion and replacement 
 */

public class ListImpl implements Serializable {

	private static final long serialVersionUID = 678851449035085377L;
	
	public static void main(String[] args) {
		System.out.println("Start the app.");
		myArrayList();
		myArrayList2();
		myVector();
		myStack();
	
	}
	
	/*
	 * The main differences between choosing between ArrayList and LinkedList is a question of performance and how the list will be accessed and modified.
	   LinkedList will perform better when adding or removing elements.
	   Arraylist will perform better getting elements.	
	 	
	 	LinkedList
			get(int index) is O(n)
			add(E element) is O(1)
			add(int index, E element) is O(n)
			remove(int index) is O(n)
			Iterator.remove() is O(1) <--- main benefit of LinkedList<E>
			ListIterator.add(E element) is O(1) <--- main benefit of LinkedList<E>
			For ArrayList<E>
		
		ArrayList	
			get(int index) is O(1) <--- main benefit of ArrayList<E>
			add(E element) is O(1) amortized, but O(n) worst-case since the array must be resized and copied
			add(int index, E element) is O(n - index) amortized, but O(n) worst-case (as above)
			remove(int index) is O(n - index) (i.e. removing last is O(1))
			Iterator.remove() is O(n - index)
			ListIterator.add(E element) is O(n - index)
	 */
	
	
	/*
	 * ArrayList implements a dynamic resized array (rather than a doubly-linked list).
	 */
	@SuppressWarnings("unused")
	private static void myArrayList() {
		ArrayList<String> colors = new ArrayList<String>();
		colors.add("red");
		colors.add("blue");
		//dump list
		System.out.println(colors);
		
		//loop over list
		for(Object o : colors){
		    System.out.println(o);    
		}
		
		//Use collections util to modify/inspect items.
		CollectionsUtil.UpperCaseItems(colors);
		
		//dump current state of collection ... may or may not be different depending on what was done in CollectionsUtil
		for(Object o : colors){
		    System.out.println(o);    
		}		
	}
		
	private static void myArrayList2() {
		ArrayList<Tree> listOfTrees = new ArrayList<Tree>();
		Tree elm = new Tree();
		elm.name = "Elm";
		elm.group = "deciduous";
		try {
			CollectionsUtil.addElementToList(listOfTrees, elm, Integer.valueOf(4));
		} catch(IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Size of array list :: " + listOfTrees.size());
	}

	/*
	 * LinkedList is not synchronized. If multiple thread access the list and one modifies the structure of the list, the list must be synchronized externally.
	 * LinkedList implements a doubly-linked list (rather than a dynamically resized array).
	 */
	private static void myLinkedList() {
		List<Tree> listB = new LinkedList<Tree>();
		
		Tree elm = new Tree();
		elm.name = "Elm";
		elm.group = "deciduous";
	
		Tree oak = new Tree();
		oak.name = "Oak";
		oak.group = "deciduous";
		
		listB.add(elm);
		listB.add(oak);
	
		
	}
	
	
	/*
	 * Vector is similar to ArrayList, the apis of each are very close.
	 * Differences:
	 * Vector is synchronized (thread safe). Use it when synchronization is necessary.
	 * Vector is more performant when resizing the underlying array is necessary.
	 * Both are good at getting elements from an index position. 
	 */
	private static void myVector() {
		//Add enums to a list ... 
		List<Enum> listC = new Vector<Enum>();
		listC.add(Apple.BRAEBURN);
		listC.add(Planet.Earth);
		
		for(Enum item : listC) {
			System.out.println(item.name() + " " + item.getClass() + " " + item.hashCode());
		}
		
	}
	
	/*
	 * Stack extends Vector. It builds a last-in-first-out stack of objects.
	 * Has normal stack operations: push, pop, peek, search, empty
	 */
	private static void myStack() {
		Stack<Tree> listD = new Stack<Tree>();
		
		Tree elm = new Tree();
		elm.name = "Elm";
		elm.group = "deciduous";
	
		Tree oak = new Tree();
		oak.name = "Oak";
		oak.group = "deciduous";
		
		listD.push(elm);
		listD.push(oak);
		
		System.out.println(((Tree)listD.pop()).name);
	}

}
