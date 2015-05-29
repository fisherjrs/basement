package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopyCharacters {
	
	private static final Logger LOG = LoggerFactory.getLogger(CopyCharacters.class);
	
	public static void main (String[] args) {
		LOG.debug("Go.");
		CopyCharacters cc = new CopyCharacters();
	}
	
	public CopyCharacters() {
		writeFile();
	}
	
	public void writeFile() {
		Number a = 234;
		try(FileReader reader = new FileReader("c:\\dev\\workspaces\\sts3.6.4\\basement\\src\\io\\lifeandtimes.txt");
				FileWriter writer = new FileWriter("fileoutput.txt");
			){
			int c;
			while((c = reader.read()) != -1) {
				writer.write(c);
			}
		}catch(IOException e){
			LOG.error("Error reading or writing file :: {} ::", a, e);
		}
	}
}