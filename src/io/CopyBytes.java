package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopyBytes{
	private static final Logger LOG = LoggerFactory.getLogger(CopyBytes.class);
	
	public static void main(String[] args) {
		LOG.debug("Go.");
		CopyBytes cb = new CopyBytes();
	}
	
	public CopyBytes() {
		readStream();
	}
	
	public FileOutputStream readStream() {
		
		try (FileInputStream in = new FileInputStream("c:\\dev\\workspaces\\sts3.6.4\\basement\\src\\io\\lifeandtimes.txt");
				FileOutputStream out = new FileOutputStream("output.txt");
				){
			
			int c;
			while((c = in.read()) != -1) {
				out.write(c);
				System.out.print(c);
			}
			return out;
		}catch(IOException e) {
			LOG.error("Error processing file", e);
		}finally{
			LOG.debug("Finally : ");
			//Keep for informational use only.
			//try-with-resources will auto close items if they implement auto-closeable
			/*
			if(in != null)
				in.close();
			
			if(out != null)
				out.close();
			*/
		}
		return null;		
	}
	
	private FileOutputStream openOutputStream() {
		try(FileOutputStream out = new FileOutputStream("outputStream.txt")){
			return out;
		}catch(IOException e) {
			LOG.error("Error creating output stream");
		}
		return null;
	}
}