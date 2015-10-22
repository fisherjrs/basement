package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class ArrayReverse {
	private static Logger LOG = LoggerFactory.getLogger(ArrayReverse.class);
	
	public static void main (String[] args) {
		
		ArrayReverse areverse = new ArrayReverse();
		
		Tree oak = new Tree();
		oak.name = "Oak";
		Tree elm = new Tree();
		elm.name = "Elm";
		Tree maple = new Tree();
		maple.name = "Maple";
		
		Tree[] objs = new Tree[3];
		objs[0] = oak;
		objs[1] = elm;
		objs[2] = maple;
		
		//Winner:: convert array to list, reverse it, then covert it back to and array..
		List<Tree> treeListA = Arrays.asList(objs);
		Collections.reverse(treeListA);
		for(Tree tree:treeListA) {
			LOG.debug(tree.name);
		}
		Tree[] objs3 = (Tree[]) treeListA.toArray();
		for(Tree tree:objs3){
			LOG.debug(tree.name);
		}
		
		
		Tree[] objs2 = areverse.reverseArray(objs);
		
		for(Tree tree:objs2) {
			LOG.debug("The tree name is :: {}", tree.name);
		}
		
		List<Tree> treeList = new ArrayList<Tree>();
		treeList.add(oak);
		treeList.add(elm);
		treeList.add(maple);
		for(Tree tree:treeList){
			LOG.debug(tree.name);
		}
		
	}
	
	public Tree[] reverseArray(Tree[] a) {
		Tree[] reverseTrees = new Tree[a.length];
		int counter = 0;
		for(int i = a.length-1; i >= 0; i--) {
			reverseTrees[counter] = a[i];
			counter++;
		}
		return reverseTrees;
	}

/*	
    public static Tree[] reverseArray(Tree[] a) {        
    	Tree[] reverseObjs = new Tree[3];
    	int counter = 0;
    	for (int i = a.length - 1; i>=0; i--) {
    		reverseObjs[counter] = a[i];
    		counter++;
    	}    	
    	return reverseObjs;
    }
*/
}
