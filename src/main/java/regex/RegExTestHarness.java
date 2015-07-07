package main.java.regex;

import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 Compile and run from command line.
     compile: javac C:\dev\workspaces\sts3.6.4\basement\src\main\java\regex\RegExTestHarness.java
     run: java -cp C:\dev\workspaces\sts3.6.4\basement\src main.java.regex.RegExTestHarness
 * 
 *
 */

public class RegExTestHarness {
	//public static final Logger LOG = LoggerFactory.getLogger(RegExTestHarness.class);
	public static void main (String[] args) {
		Console console = System.console();
		if (console == null){
			//LOG.debug("No console");
			System.out.print("No console");
		}
		
		System.out.print("go");
		while(true) {
			System.out.print("now");
			Pattern pattern = 
		            Pattern.compile(console.readLine("%nEnter your regex: "));

		            Matcher matcher = 
		            pattern.matcher(console.readLine("Enter input string to search: "));

		            boolean found = false;
		            while (matcher.find()) {
		                console.format("I found the text" +
		                    " \"%s\" starting at " +
		                    "index %d and ending at index %d.%n",
		                    matcher.group(),
		                    matcher.start(),
		                    matcher.end());
		                found = true;
		            }
		            if(!found){
		                console.format("No match found.%n");
		            }
		}
	}
}