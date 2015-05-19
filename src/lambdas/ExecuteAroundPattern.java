package lambdas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecuteAroundPattern {
	
	private static Logger LOG = LoggerFactory.getLogger(ExecuteAroundPattern.class);
	
	@FunctionalInterface
	public interface BufferedReaderProcessor {
		String process(BufferedReader b) throws IOException;
	}
	
	/*
	 * Instead of having a function that reads from a file and performs a defined operation on the file. It's possible to read from a file
	 * and apply a function that is passed in as a parameter. 
	 * 		The function is defined by a lambda expression
	 * 		A functional interface needs to be created
	 * 		The function that opens the reader needs to accept the functional interface as a parameter
	 * 
	 * This allows multiple implementation of reader processing w/o multiple functions to open the reader.
	 * It's an enhancement to the execute-around pattern.
	 */
	
	public static void main(String[] args) {
		try{
			String result = processFile( (BufferedReader br) -> br.readLine() + br.readLine() );
			LOG.debug(result);
			String result2 = processFile( (BufferedReader br) -> br.read() + " :: one character ::" + br.readLine() );
			LOG.debug(result2);
		}catch(IOException e) {
			LOG.debug(e.getMessage());
		}
	}
	
	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try(BufferedReader br =
				new BufferedReader(new FileReader("c:/dev/workspaces/sts3.6.4/basement/src/lambdas/data.txt"))){
			return p.process(br);
		}
	}
}