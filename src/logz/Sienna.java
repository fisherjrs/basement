package logz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Sienna has it's own Logger configured in log4j2.xm (unless I've changed it without updating this comment. 12/18/14
 */

public class Sienna {

	//It's possible to get the logger by class, by name defined in loggers in log4j2.xml or by getting the root logger.
	//private static Logger LOG = LogManager.getLogger(Sienna.class);
	//private static Logger LOG = LogManager.getLogger("brisket");
	private static Logger LOG = LogManager.getRootLogger();
	
	public static void main(String[] args) {
		LOG.trace("Logger trace message.");
        LOG.debug("Logger debug message");
        LOG.info("Logger info message");
        LOG.warn("Logger warn message");
        LOG.error("Logger error message");
        LOG.fatal("Logger fatal message");
        
        Scarlet myscarlet = new Scarlet();
        
	}

}
