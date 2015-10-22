package threads;

public class Bank {
    private int funds = 100;
    private Object fundLock;

    private UserDetails details = new UserDetails();

    public void deposit(int money){
        synchronized (fundLock){ //Lock Object needs to be acquired to update funds 
            funds += money;
        }
    }

    //BAD use of synchronized ... we don't need to lock the entire method.
    public synchronized void createUsername(){
    	details.setName("Tommy");
    }
    
    //BETTER use of synchronized ... only locks read/write from object.
    public void createUsername(String name){
        synchronized (details){ //Lock on the details object mean that the details object will block, but Bank will not.
            details.setName(name);
        }
        System.out.println(String.format("His name is %s", name));
    }

    public class UserDetails {
    	private String name;
    	public UserDetails() {
    		
    	}
    	
    	public String getName() {
    		return name;
    	}
    	
    	public void setName(String name) {
    		this.name = name;
    	}
    }
}
