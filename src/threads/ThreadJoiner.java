package threads;

public class ThreadJoiner implements Runnable {

	public ThreadJoiner() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main (String[] args) {
		Thread thread = new Thread(new ThreadJoiner());
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(3);
	}
	
	@Override
	public void run() {
		int i = 0;
		while(i < 1000) {
			System.out.println(i);
			i++;
		}
	}
	
}
/*
public class SayHelloRunner implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SayHelloRunner());
        thread.start();
        thread.join();
        System.exit(3);
    }

    @Override
    public void run() {
        int i = 0;
        while(i < 10000){
            System.out.println(i);
            i++;
        }
    }
}
*/
