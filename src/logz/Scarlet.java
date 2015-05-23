package logz;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Scarlet {

	private static Logger LOG = LoggerFactory.getLogger(Scarlet.class);
	
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
