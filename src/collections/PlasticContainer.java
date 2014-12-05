package collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * A collection is a container that groups multiple elements into a single unit.
 *
 * Collection is an interfaces. It has a core set of sub-interfaces: Set, List, Queue.
 * Each of the sub-interfaces have concrete classes and more interfaces.
 * List: ArrayList, Vector, LinkedList
 * Queue: Deque(I)
 * Set: HashSet, LinkedHashSet
 * A Map is not a collection in the java world, although it does group elements into a single unit.
 * 
 */

public class PlasticContainer implements Serializable {

	private static final long serialVersionUID = 678851449035085377L;

	public static void main(String[] args) {
		System.out.println("Start the app.");
		myArrayList();
		myHashSet();
	}
	
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
	
	/**
	 * HashSet does not guarantee any insertion order.
	 * It does allow null elements. 
	 * It can be used in place of ArrayList to store objects if you require no duplicate and don't care about insertion order.
	 * It provides constant time performance for operations such as add, remove, contains, etc ...
	 * HashSet is not synchronized. If separate threads access the set, and one of them modifies the set, the set must be synchronized externally.
	 * 
	 */
	@SuppressWarnings("unused")
	private static void myHashSet() {
		Collection<String> hashSet1 = new HashSet<String>();
		hashSet1.add("The sky is blue.");
		hashSet1.add("Trees are tall.");
		
		for (Object o : hashSet1) {
			System.out.println("HashSet loop 1 :: " + o);
		}
	}
	
	

}
