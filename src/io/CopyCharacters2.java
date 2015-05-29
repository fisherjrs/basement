package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopyCharacters2 {
	
	private static final Logger LOG = LoggerFactory.getLogger(CopyCharacters2.class);

	public static void main(String[] args) {
		LOG.debug("Go.");
		CopyCharacters2 cc2 = new CopyCharacters2();
	}
	
	public CopyCharacters2() {
		writeFile();
		readNewFile();
	}
	
	private void writeFile() {
		String inputName = "c:\\dev\\workspaces\\sts3.6.4\\basement\\src\\io\\lifeandtimes.txt";
		String outputName = "fileoutput.txt";
		try(FileReader input = new FileReader(inputName);
				FileWriter output = new FileWriter(outputName);
				){
			int c = 0;
			while((c = input.read()) != -1) {
				output.write(c);
			}
		}catch(IOException e) {
			LOG.error("Error reading or writing file {}, {}", inputName, outputName, e);
		}
	}
	
	private void readNewFile() {
		String fileName = "fileoutput.txt";
		try(FileReader in = new FileReader(fileName)) {
			int c = 0;
			while((c = in.read()) != 0) {
				System.out.print(c);
			}
		}catch(IOException e) {
			LOG.error("Error reading new file {}", fileName, e);
		}
	}
}