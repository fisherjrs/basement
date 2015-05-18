package lambdas;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.Comparator;
import java.util.function.Predicate;
import java.lang.Iterable;
import java.time.chrono.IsoChronology;
 
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
 
public class RosterTest {
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
    	for( Person person : roster ) {
    		if( low < person.getAge() && person.getAge() < high ) {
    			person.printPerson();
    		}
    	}
        
    }
 
    // Approach 3: Specify Search Criteria Code in a Local Class
    // Approach 4: Specify Search Criteria Code in an Anonymous Class
    // Approach 5: Specify Search Criteria Code with a Lambda Expression
 
    public static void printPersons(
        List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
 
    // Approach 6: Use Standard Functional Interfaces with Lambda Expressions
 
    public static void printPersonsWithPredicate(
        List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
 
    // Approach 7: Use Lambda Expressions Throughout Your Application
 
    public static void processPersons(
        List<Person> roster,
        Predicate<Person> tester,
        Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }
 
    // Approach 7, second example
 
    public static void processPersonsWithFunction(
        List<Person> roster,
        Predicate<Person> tester,
        Function<Person, String> mapper,
        Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
     
    // Approach 8: Use Generics More Extensively
 
    public static <X, Y> void processElements(
        Iterable<X> source,
        Predicate<X> tester,
        Function<X, Y> mapper,
        Consumer<Y> block) {
            for (X p : source) {
                if (tester.test(p)) {
                    Y data = mapper.apply(p);
                    block.accept(data);
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
 
        class CheckPersonEligibleForSelectiveService implements CheckPerson {
           public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                    && p.getAge() >= 18
                    && p.getAge() <= 25;
            }
        }
 
        printPersons(
            roster, new CheckPersonEligibleForSelectiveService());
 
 
        LOG.debug("");
       
        // Approach 4: Specify Search Criteria Code in an Anonymous Class
 
        LOG.debug("Persons who are eligible for Selective Service " +
            "(anonymous class):");
 
        printPersons(
            roster,
            new CheckPerson() {
                public boolean test(Person p) {
                    return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
                }
            }
        );
 
        LOG.debug("");
 
        // Approach 5: Specify Search Criteria Code with a Lambda Expression
 
        LOG.debug("Persons who are eligible for Selective Service " +
            "(lambda expression):");
 
        printPersons(
            roster,
            (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25
        );
 
        LOG.debug("");
 
        // Approach 6: Use Standard Functional Interfaces with Lambda
        // Expressions
 
        LOG.debug("Persons who are eligible for Selective Service " +
            "(with Predicate parameter):");
 
        printPersonsWithPredicate(
            roster,
            p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25
        );
 
        LOG.debug("");
 
        // Approach 7: Use Lamba Expressions Throughout Your Application
 
        LOG.debug("Persons who are eligible for Selective Service " +
            "(with Predicate and Consumer parameters):");
 
        processPersons(
            roster,
            p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25,
            p -> p.printPerson()
        );
 
        LOG.debug("");
 
        // Approach 7, second example
 
        LOG.debug("Persons who are eligible for Selective Service " +
            "(with Predicate, Function, and Consumer parameters):");
 
        processPersonsWithFunction(
            roster,
            p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25,
            p -> p.getEmailAddress(),
            email -> LOG.debug(email)
        );
 
        LOG.debug("");
 
        // Approach 8: Use Generics More Extensively
 
        LOG.debug("Persons who are eligible for Selective Service " +
            "(generic version):");
 
        processElements(
            roster,
            p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25,
            p -> p.getEmailAddress(),
            email -> LOG.debug(email)
        );
 
        LOG.debug(" ");
 
        // Approach 9: Use Bulk Data Operations That Accept Lambda Expressions
        // as Parameters
 
        LOG.debug("Persons who are eligible for Selective Service " +
            "(with bulk data operations):");
 
        roster
            .stream()
            .filter(
                p -> p.getGender() == Person.Sex.MALE
                    && p.getAge() >= 18
                    && p.getAge() <= 25)
            .map(p -> p.getEmailAddress())
            .forEach(email -> LOG.debug(email));
          
     }
}

