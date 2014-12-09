package collections;

import java.io.Serializable;
import java.util.HashSet;

/*
 * Sets are collections that contain no duplicates and only one null (it contains no elements such that e1.equals(e2)).
 */

public class SetImpl implements Serializable {

	private static final long serialVersionUID = -5439822758403811590L;

	public static void main(String[] args) {
		System.out.println("Start the app.");
		myHashSet();
	}
	
	/*
	 * HashSet implements the Set interface, backed by a hash table (actually a HashMap instance).
	 */
	public static void myHashSet() {
		HashSet<Tree> hash = new HashSet<Tree>();
		
		Tree elm = new Tree();
		elm.name = "Elm";
		elm.group = "deciduous";
	
		Tree oak = new Tree();
		oak.name = "Oak";
		oak.group = "deciduous";
		
		hash.add(elm);
		hash.add(oak);
		
		System.out.println(hash.isEmpty());
	}
}
