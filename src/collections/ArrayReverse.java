package collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayReverse {
	private static Logger LOG = LogManager.getLogger(ArrayReverse.class);
	
	public static void main (String[] args) {
		Tree oak = new Tree();
		oak.name = "Oak";
		Tree elm = new Tree();
		elm.name = "Elm";
		Tree maple = new Tree();
		maple.name = "Maple";
		
		Object[] objs = new Object[3];
		objs[0] = oak;
		objs[1] = elm;
		objs[2] = maple;
		
		Object[] objs2 = reverseArray(objs);
		for (int i = 0; i<objs.length; i++) {
			LOG.debug(((Tree)objs2[i]).name);
		}
	}

    public static Object[] reverseArray(Object[] a) {        
    	Object[] reverseObjs = new Object[3];
    	int counter = 0;
    	for (int i = a.length - 1; i>=0; i--) {
    		reverseObjs[counter] = a[i];
    		counter++;
    	}    	
    	return reverseObjs;
    }
}
