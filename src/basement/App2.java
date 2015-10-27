package basement;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class App2{
	private static Logger LOG = LogManager.getLogger(App2.class);
	
	public static void main(String[] args) {
		LOG.warn("Start app 2.");
		LOG.warn("Second line goes here.");
	}
}