package collections;

import java.io.Serializable;
import java.util.ArrayList;
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

	private static final long serialVersionUID = 4387372452560371581L;
	
	
	
	public static void main(String[] args) {
		System.out.println("Start the app.");
		init();
	}
	
	private static void init() {
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
	
	

}
