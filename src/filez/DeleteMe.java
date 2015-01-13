package filez;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteMe {

	public static void main(String[] args) {
		Path myPath = null;
		try {
		    myPath = Paths.get("c:/tmp/red");
			Files.delete(myPath);
		} catch (NoSuchFileException x) {
		    System.err.format("%s: no such" + " file or directory%n", myPath);
		} catch (DirectoryNotEmptyException x) {
		    System.err.format("%s not empty%n", myPath);
		} catch (IOException x) {
		    // File permission problems are caught here.
		    System.err.println(x);
		}

	}

}
