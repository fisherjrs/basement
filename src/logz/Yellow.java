package logz;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Yellow {

	private static Logger LOG = LogManager.getLogger(Yellow.class);
	
	public static void main(String[] args) {
		LOG.trace("Logger trace message.");
        LOG.debug("Logger debug message");
        LOG.info("Logger info message");
        LOG.warn("Logger warn message");
        LOG.error("Logger error message");
        
        Integer designId = 1287409087;
        String sessionId = "law45ojafowou ow47aaoseru23ojafo23urafjaoufw823ajfwoe";
        
        Scarlet myscarlet = new Scarlet();
        
        designId = myscarlet.getDesignId();
        try{
	        if(designId > 100) {
	        	LOG.debug("Print designId {}", designId);
	        }
        }catch(Exception e){
        	LOG.error("Error reading designId {}", e);
        }
        
        try{
        	throwMyException();
        }catch(IOException x){
        	LOG.error("SessionId:{}, DesignId:{} - Error trying to create buffered reader for file {}", sessionId, myscarlet.getDesignId(), x.getMessage());
        };
	}

	
	public static void throwMyException() throws IOException{
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("c:\\dev\\IDONTEXIST.TXT"), charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		    }
		} catch (IOException x) {
		    throw(x);
		}
	
	}
}
