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
		TimeMarker tm = new TimeMarker();
		tm.start();
	}
	
	static class TimeMarker extends Thread {		
		@Override
		public void run() {
			/*while(MY_INT < 5) {
				LOG.info(String.format("TimeMarker info %s ", MY_INT));
				MY_INT++;
				try{
					Thread.sleep(500);
				} catch(InterruptedException e) {
					LOG.error("Error in TimeMarker thread.");
				}
			}*/
			
			LOG.info("thread is running.");
		}
	}
	
}
