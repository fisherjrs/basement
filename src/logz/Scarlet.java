package logz;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/*
 * Sienna has it's own Logger configured in log4j2.xm (unless I've changed it without updating this comment. 12/18/14
 */

public class Scarlet {

	private static Logger LOG = LoggerFactory.getLogger(Scarlet.class);
	
	public Scarlet() {
		LOG.trace("Logger trace message.");
        LOG.debug("Logger debug message");
        LOG.info("Logger info message");
        LOG.warn("Logger warn message");
        LOG.error("Logger error message");
        
	}
}
