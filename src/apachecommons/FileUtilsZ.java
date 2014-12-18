package apachecommons;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileUtilsZ {
	
	private static Logger LOG = LogManager.getLogger(FileUtilsZ.class);
	
	public static void main(String[] args) {
		LOG.debug("Start the app.");
		
		String tempDir = FileUtils.getTempDirectoryPath();
		LOG.debug("tempDir :: " + tempDir);
	}

}
