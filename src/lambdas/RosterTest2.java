package lambdas;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.Comparator;
import java.util.function.Predicate;
import java.lang.Iterable;
import java.time.chrono.IsoChronology;
 

import lambdas.RosterTest.CheckPerson;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class RosterTest2 {
	
	private static Logger LOG = LogManager.getLogger(RosterTest.class);

	interface CheckPerson {
		boolean test(Person p);
	}

    // Approach 1: Create Methods that Search for Persons that Match One
    // Characteristic
    public static void printPersonsOlderThan(List<Person> roster, int age) {
    	for(Person person : roster) {
    		if(person.getAge() > age) {
    			person.printPerson();
    		}
    	}
    }
 
 
    // Approach 2: Create More Generalized Search Methods
 
    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
    	for(Person person : roster) {
    		if( low < person.getAge() && person.getAge() < high ) {
    			person.printPerson();
    		}
    	}
        
    }
    
    // Approach 3, 4, 5:
    public static void printPersons(List<Person> roster, CheckPerson check) {
    	for(Person person : roster) {
    		if(check.test(person)) {
    			person.printPerson();
    		}
    	}
    }
    
    //Approach 6:
    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
    	for(Person person : roster) {
    		if(tester.test(person)) {
    			person.printPerson();
    		}
    	}
    }
    
    //Approach 7
    public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block){
    	for(Person person : roster) {
    		if(tester.test(person)) {
    			block.accept(person);
    		}
    	}
    }
 

 
    public static void main(String... args) {
 
        List<Person> roster = Person.createRoster();
 
        for (Person p : roster) {
            p.printPerson();
        }
 
        // Approach 1: Create Methods that Search for Persons that Match One
        // Characteristic
 
        printPersonsOlderThan(roster, 20);
        LOG.debug("Persons older than 20:");
        LOG.debug("");
 
        // Approach 2: Create More Generalized Search Methods

        LOG.debug("Persons between the ages of 14 and 30:");
        printPersonsWithinAgeRange(roster, 14, 30);
        LOG.debug("");
 
        // Approach 3: Specify Search Criteria Code in a Local Class

        LOG.debug("Persons who are eligible for Selective Service:");
        class CheckPersonsEligibleForSelectiveService implements CheckPerson {
        	public boolean test(Person p){
        		return p.getGender() == Person.Sex.MALE && p.getAge() > 17 && p.getAge() < 25;
        	}
        }
        
        printPersons(roster, new CheckPersonsEligibleForSelectiveService());
        
        //4. use anonymous class instead of declaring new class
        printPersons(roster, new CheckPerson(){
        	public boolean test(Person p){
        		return p.getGender() == Person.Sex.MALE && p.getAge() > 17 && p.getAge() < 25; 
        	}
        });
        
        //5. use lambda expressions
        printPersons(roster, (Person p) -> p.getGender() == Person.Sex.MALE && p.getAge() > 17 && p.getAge() < 2);
        
        //6. use functional interface
        printPersonsWithPredicate(roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() > 17 && p.getAge() < 25);
        
        //7. use more functional interfaces
        processPersons(roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() > 17 && p.getAge() < 25, p -> p.printPerson() );
    }
}
