package logz;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Yellow {

	private static Logger LOG = LogManager.getLogger(Yellow.class);
	
	public static void main(String[] args) {
		LOG.trace("Logger trace message.");
        LOG.debug("Logger debug message");
        LOG.info("Logger info message");
        LOG.warn("Logger warn message");
        LOG.error("Logger error message");
        
        Scarlet myscarlet = new Scarlet();
        
	}

}
