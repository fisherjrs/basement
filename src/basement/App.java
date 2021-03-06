package basement;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class App {
	private static Logger LOG = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App.myMysteryMethod(9);
		Hero h = new Hero();
		h.fight(new Dragon());
		LOG.debug("a :: " + h.health);
		int i = 45;
		switch(i){
			case 15 : case 23 : case 45 :
				System.out.println("erwft");
				break;
			default :
				System.out.println("jiggity");
		}
		
	}
	
	public static void myMysteryMethod ( int max )
	{
	  for ( int i = 1; i <= max; i++ ) {
	    for ( int j = 1; j <= max; j++ ) {
	    	
	    	System.out.print ( String.format ( "%6d", j * i ));
	      
	    }
	    System.out.println();
	  }
	}
	
	public static class Dragon { 
	  public Damage breathFire(){
	    return new Damage(100);
	  }
	}
	
	public static class Hero {
	  private int health = 500;
	  public void fight(Dragon dragon){
	    health -= dragon.breathFire().getAmount();
	  }
	}
	
	public static class Damage{
	  private int amount;
	  public Damage(int amount){
	    this.amount = amount / 2;
	  }
	  public int getAmount(){
		  return amount;
	  }
	}
	

}
