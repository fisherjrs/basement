package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class ArrayReverseList {
	private static Logger LOG = LoggerFactory.getLogger(ArrayReverseList.class);
	
	public static void main (String[] args) {
		
		ArrayReverseList areverse = new ArrayReverseList();
		
		Tree oak = new Tree();
		oak.name = "Oak";
		Tree elm = new Tree();
		elm.name = "Elm";
		Tree maple = new Tree();
		maple.name = "Maple";
		
		List<Tree> objs = new ArrayList<Tree>();
		objs.add(oak);
		objs.add(elm);
		objs.add(maple);
		
		for(Tree tree:objs) {
			LOG.debug("The tree name is :: {}", tree.name);
		}
		
		Collections.reverse(objs);	
			
		for(Tree tree:objs) {
			LOG.debug("The tree name is :: {}", tree.name);
		}
	}

}
