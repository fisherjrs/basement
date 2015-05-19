package threads;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import threads.ThreadVolatile.ChangeListener;

public class BasicThread {

	private static Logger LOG = LoggerFactory.getLogger(BasicThread.class);
	private static int MY_INT = 0;
	
	public static void main(String[] args) {
		LOG.info("Start the BasicThread app.");
		new TimeMarker().start();
	}
	
	static class TimeMarker extends Thread {		
		@Override
		public void run() {
			while(MY_INT < 5) {
				LOG.info("TimeMarker info");
				LOG.warn("TimeMarker warn");
				try{
					Thread.sleep(500);
				} catch(InterruptedException e) {
					LOG.error("Error in TimeMarker thread.");
				}
			}
		}
	}
	
}
