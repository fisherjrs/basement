package collections;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class RedBlue {

	public static void main(String[] args) {
		System.out.println("Start your app.");
		go();
	}
	
	protected static void go() {
		Tree elm = new Tree();
		elm.setName("Elm");
		elm.setInfo("An elm is a really tall tree.");
		elm.setGroup("Deciduous");
		elm.setHeight(45);
		elm.setWidth(30);
		
		Class<?> myclass = elm.getClass();
		Field[] fields = myclass.getDeclaredFields();
		Map<String, Object> mymap = new HashMap<String, Object>();
		try {
			for(Field field : fields) {
				StringBuilder propertyDef = new StringBuilder("The properties for a tree object :: ");
				propertyDef.append(field.getType());
				propertyDef.append(" :: ");
				propertyDef.append(field.getName());
				propertyDef.append(" :: ");
				propertyDef.append(field.get(elm));
				System.out.println(propertyDef.toString());
				
				//We can also add the name value pairs to a map.
				mymap.put(field.getName().toString(), field.get(elm));
			}
		} catch(Exception e) {
			System.out.println("Error occurred" + e.getMessage());
		}
		
		for(Map.Entry<String, Object> entry : mymap.entrySet()) {
			System.out.println(entry.getKey() + " :: " + entry.getValue());
		}
		
	}
}
