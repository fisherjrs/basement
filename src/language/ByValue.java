package language;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ByValue {
	
	private static Logger LOG = LoggerFactory.getLogger(ByValue.class);
	private static final String MOOD_HAPPY = "Happy";
	private static final String MOOD_PLAYFUL = "Playful";
	
	public static void main(String[] args) {
		LOG.debug("Go.");
		ByValue bv = new ByValue();
		Dog dog1 = bv.createDog();
		LOG.debug(String.format("Dog 1 name:: %4s %4s", dog1.getName(), dog1.getPersonality().getMood()));
		bv.changeDogName(dog1);
		LOG.debug(String.format("Dog 1 name AFTER :: %4s %4s", dog1.getName(), dog1.getPersonality().getMood()));
		
	}
	
	public Dog createDog() {
		Dog d1 = new Dog("Fifi");
		return d1;
	}
	
	public void changeDogName(Dog dog) {
		dog.setName("Franz");
		dog.getPersonality().setMood(MOOD_PLAYFUL);
		LOG.debug(String.format("Dog change :: %4s, %4s", dog.getName(), dog.getPersonality().getMood()));
		
	}
		
	private class Dog {
		String name;
		Personality personality;
		
		public Dog(String dogName){
			name = dogName;
			personality = new Personality(MOOD_HAPPY);
		}
		
		public String getName(){ 
			return name;
		}
		
		public void setName(String dogName) {
			name = dogName;
		}
		
		public Personality getPersonality() {
			return personality;
		}
		
	}
	
	private class Personality {
		String mood;
		public Personality(String mood){
			this.mood = mood;
		}
		
		public void setMood(String mood) {
			this.mood = mood;
		}
		
		public String getMood() {
			return mood;
		}
	}
}