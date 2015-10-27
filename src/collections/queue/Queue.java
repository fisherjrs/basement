package collections.queue;

import java.util.NoSuchElementException;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Queue {
	private static Logger LOG = LoggerFactory.getLogger(Queue.class);
	
	Stack<String> stackOne = new Stack<String>();
	Stack<String> stackTwo = new Stack<String>();
	
	private static void main (String[] args) {
		Queue q = new Queue();
	}
	
	public void add(String item) {
		stackOne.push(item);
	}
	
	public String remove() {
		if(stackOne.isEmpty() && stackTwo.isEmpty()){
			throw new NoSuchElementException("The queue is empty.");
		}
		
		if(stackTwo.isEmpty()) {
			while(!stackOne.isEmpty()) {
				stackTwo.push(stackOne.pop());
			}
		}
		return stackTwo.pop();
	}
}