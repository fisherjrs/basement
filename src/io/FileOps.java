package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileOps {
	private static final Logger LOG = LoggerFactory.getLogger(FileOps.class);
	
	public static void main(String[] args){
		
		OutputStream pdfStream = null;
		try{
		pdfStream = new FileOutputStream(validatePath("C:\\46\\5500043964507\\07\\globber.pdf"));
		}catch(FileNotFoundException e){
			LOG.debug("File not found", e);
		}
	
	}
	
	private static String validatePath(String fileName) {
		
		File newFile = new File(fileName);		
		
		int index = fileName.lastIndexOf("\\");
		String pathName = fileName.substring(0, index);
		LOG.debug("path name {}", pathName );
		
		File f1 = new File(pathName);
		
		try{
		LOG.debug("file path {}", f1.getCanonicalPath());
		LOG.debug("file exists {}", f1.exists());
		if(!f1.exists()) {
			f1.mkdirs();
		}
		} catch(Exception e) {
			LOG.debug("file error {}", e.getMessage());
		}
		return fileName;
	}
}
