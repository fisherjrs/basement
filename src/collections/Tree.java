package collections;

import java.io.Serializable;
import java.util.HashMap;

/**
 * This is a bean. It implements Serializable, it has a zero arg constructor and it has public getters/setters.
 * A class that implements Serializable will have their state serialized and deserialized.
 * It's strongly recommended that Serializable classes declare the serialVersionUID.
 */
public class Tree implements Serializable {
	
	private static final long serialVersionUID = 42L;
	
	public String name;
	public String group;
	public String info;
	public Number height;
	public Number width;
	
	
	public Tree() {
		System.out.println("Plant a tree.");
		//System.out.println(serialVersionUID);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Number getHeight() {
		return height;
	}

	public void setHeight(Number height) {
		this.height = height;
	}

	public Number getWidth() {
		return width;
	}

	public void setWidth(Number width) {
		this.width = width;
	}

}
