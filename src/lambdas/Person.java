package lambdas;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Person {
	private static Logger LOG = LogManager.getLogger(Person.class);
	
	public enum Sex {
		FEMALE, MALE;
	}
	
	private String name;
	private LocalDate birthday;
	private Sex gender;
	private String emailAddress;
	
	public Person() {
		
	}
	
	public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}
	
	public int getAge() {
		return birthday.until(IsoChronology.INSTANCE.dateNow()).getYears();
	}
	
	public String getName() {
		return name;
	}
	
	public Sex getGender() {
		return gender;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void printPerson() {
		LOG.debug(this.getName());
	}
	
	public static int compareByAge(Person a, Person b) {
		return a.birthday.compareTo(b.birthday);
	}
	
	public static List<Person> createRoster() {
		List<Person> roster = new ArrayList<Person>();
		roster.add(
				new Person("Jackson Pollock", 
				IsoChronology.INSTANCE.date(1980, 11, 2), 
				Person.Sex.MALE, 
				"gfda@fsllass.com"));
        roster.add(
                new Person(
                "Fred",
                IsoChronology.INSTANCE.date(1980, 6, 20),
                Person.Sex.MALE,
                "fred@example.com"));
        roster.add(
                new Person(
                "Jane",
                IsoChronology.INSTANCE.date(1990, 7, 15),
                Person.Sex.FEMALE, "jane@example.com"));
        roster.add(
                new Person(
                "George",
                IsoChronology.INSTANCE.date(1991, 8, 13),
                Person.Sex.MALE, "george@example.com"));
        roster.add(
                new Person(
                "Bob",
                IsoChronology.INSTANCE.date(2000, 9, 12),
                Person.Sex.MALE, "bob@example.com"));		
		return roster;
		
	}
}