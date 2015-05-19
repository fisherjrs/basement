package logz;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Yellow {

	private static Logger LOG = LoggerFactory.getLogger(Yellow.class);
	
	public static void main(String[] args) {
		LOG.trace("Logger trace message.");
        LOG.debug("Logger debug message");
        LOG.info("Logger info message");
        LOG.warn("Logger warn message");
        LOG.error("Logger error message");
        
        Scarlet myscarlet = new Scarlet();
        
	}

}
