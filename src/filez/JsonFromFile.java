package filez;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonFromFile {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		 
        try {
 
            Object obj = parser.parse(new FileReader("c:/dev/workspaces/sts3.6.4/basement/src/filez/categories.json"));
 
            JSONObject jsonObject = (JSONObject) obj;
            
            System.out.println(jsonObject);
 /*
            String name = (String) jsonObject.get("name");
            String author = (String) jsonObject.get("Author");
            JSONArray categories = (JSONArray) jsonObject.get("categories");
 
            System.out.println("Name: " + name);
            System.out.println("Author: " + author);
            System.out.println("\nCompany List:");
            Iterator<String> iterator = categories.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
           */
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
