package lambdas;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RosterTest2 {
	private static Logger LOG = LoggerFactory.getLogger(RosterTest2.class);
	
	public static RosterTest2 getRosterTest() {
		return new RosterTest2();
	}
	
	private RosterTest2() {
		
	}
	
	void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
		for(Person person : roster) {
			if(tester.test(person)) {
				LOG.debug(person.getName() + " " + person.getEmailAddress());
			}
		}
	}
	
	void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block){
		for(Person person : roster) {
			if(tester.test(person)) {
				block.accept(person);
			}
		}
	}
	
	void processPersonsWithFunction(List<Person> roster,
			Predicate<Person> tester,
			Function<Person, String> mapper,
			Consumer<String> block) {
		for(Person person : roster) {
			if(tester.test(person)) {
				String data=mapper.apply(person);
				block.accept(data);
			}
		}
	}
	
	public static void main(String[] args) {
		RosterTest2 rt2 = getRosterTest();
		List<Person> roster = Person.createRoster();
		
		rt2.printPersonsWithPredicate(roster, p -> p.getGender() == Person.Sex.FEMALE);
		rt2.processPersons(roster, 
				p -> p.getAge() > 17 && p.getAge() < 25, 
				p -> p.printPerson()
				);
		
		rt2.processPersonsWithFunction(roster, 
				p -> p.getAge() < 50, 
				p -> p.getGreeting(), 
				greeting -> LOG.debug(greeting));
	}
	
}