package threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadVolatile {
	
	private static int MY_INT = 0;
	private static Logger LOG = LogManager.getLogger(ThreadVolatile.class);
	
	public static void main(String[] args) {
		new ChangeListener().start();
		//new ChangeMaker().start();
	}
	
	static class ChangeListener extends Thread {
		@Override
		public void run(){
			int local_value = MY_INT;
			while(MY_INT < 5) {
				LOG.debug("Got Change for MY_INT : " + MY_INT + " local_value is " + local_value);
				try{
					Thread.sleep(500);
				}catch(InterruptedException e){
					System.out.println(e.getMessage());					
				}
			}
		}
	}
	
	static class ChangeMaker extends Thread {
		@Override
		public void run() {
			int local_value = MY_INT;
			while(MY_INT < 5) {
				MY_INT = ++local_value;
				LOG.debug("Incremented MY_INT : " + MY_INT + " local_value is " + local_value);
				try{
					Thread.sleep(500);
				}catch(InterruptedException e){
					LOG.debug(e.getMessage());					
				}
			}
		}
	}

}
