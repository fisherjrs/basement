package threads;

public class ThreadTest implements Runnable {
	
	private volatile boolean running = true;
	private Bank bank;
	
	public static void main(String[] args) {
		ThreadTest tt = new ThreadTest();
		new Thread(tt).start();
		//new Thread(new SayHelloRunner()).start();
	}
	
	public ThreadTest() {
		bank = new Bank();
	}
	
    @Override
    public void run() {
    	while(running) {
	        for (int i = 0; i < 100; i++) {
	            System.out.println("Hi there!");
	            bank.createUsername("ABCDEFG");
	            if(i == 50){
	            	running = false;
	            }
	        }
    	}
    }

}