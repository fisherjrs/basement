package apachecommons;

import org.apache.commons.io.FileUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class FileUtilsZ {
	
	private static Logger LOG = LoggerFactory.getLogger(FileUtilsZ.class);
	
	public static void main(String[] args) {
		LOG.debug("Start the app.");
		
		String tempDir = FileUtils.getTempDirectoryPath();
		LOG.debug("tempDir :: " + tempDir);
	}

}
