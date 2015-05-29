package logz;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Scarlet {

	private static Logger LOG = LogManager.getLogger(Scarlet.class);
	
	private Integer designId;
	
	public Scarlet() {
		LOG.trace("Logger trace message.");
        LOG.debug("Logger debug message");
        LOG.info("Logger info message");
        LOG.warn("Logger warn message");
        LOG.error("Logger error message");
        
	}
	
	public Integer getDesignId() {
		return this.designId;
	}
}
