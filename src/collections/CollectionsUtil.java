package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionsUtil {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void UpperCaseItems(Collection collection) {
		
		//Basic iterator ... cannot modify collection using this method.
		Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			Object object = iterator.next();
			if (object instanceof String) {
				System.out.println(((String) object).toUpperCase());
				//object = ((String) object).toUpperCase();  doesn't actually change the underlying object.
			}
		}
		
		//old school for loop ... can modify collection. This is not a structural change to the collection, just a change to the members. Structural collection changes in a loop is not recommended.
		if(collection instanceof ArrayList) {
			for (int i=0; i < collection.size(); i++) {
				Object object = ((ArrayList) collection).get(i);
				String item = ((String)object);
				((ArrayList)collection).set(i, item.toUpperCase() );	
			}
		}
	}
	
	/*
	 * As this stands it's too specific to belond in a util class. 
	 */
	public static void addElementToList(ArrayList<Tree> myArrayList, Tree myTree, Integer position) throws IndexOutOfBoundsException {
		
		//Tree is allowed to be null. Should it be?
		
		if(myArrayList != null) {
			if(position == null || position.intValue() < 0) {
				position = Integer.valueOf(myArrayList.size());
			}
			try {
				myArrayList.add(position.intValue(), myTree);
			} catch (IndexOutOfBoundsException e) {
				throw(e);
			}
		} else {
			System.out.println("The array list is null. Create? Ignore? Throw error?");
		}
		
	}
}
