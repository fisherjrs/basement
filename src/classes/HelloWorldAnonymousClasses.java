package classes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldAnonymousClasses {
	private static Logger LOG = LoggerFactory.getLogger(HelloWorldAnonymousClasses.class);

	interface HelloWorld {
		public void greet();
		public void greetSomeone(String someone);
	}
	
	public static void main(String[] args) {
		HelloWorldAnonymousClasses hello = new HelloWorldAnonymousClasses();
		hello.sayHello();
	}
	
	public void sayHello() {
		class EnglishGreeting implements HelloWorld {
			public void greet() {
				greetSomeone("English Dan and John Ford Coley.");
			}
			
			public void greetSomeone(String someone) {
				LOG.debug("Hello " + someone);
			}
		}
		
		HelloWorld spanishGreeting = new HelloWorld(){
			public void greet(){
				greetSomeone("Spanish Guy.");
			}
			
			public void greetSomeone(String someone){
				LOG.debug("Hello " + someone);
			}
		};
		
		HelloWorld frenchGreeting = new HelloWorld(){
			public void greet(){
				greetSomeone("French Guy");
			}
			
			public void greetSomeone(String someone) {
				LOG.debug("Hello " + someone);
			}
		};
		
		EnglishGreeting englishGreeting = new EnglishGreeting();
		englishGreeting.greet();
		
		spanishGreeting.greet();
		frenchGreeting.greet();
	}
}