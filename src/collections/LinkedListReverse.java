package collections;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListReverse {

	public LinkedListReverse() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		LinkedListReverse llr = new LinkedListReverse();
		List<LinkedListNode> listA = llr.createListA();
		
		//llr.reverseIterative(n0);
		
		System.out.println(String.format("The value at position 0 :: %s", listA.get(0).data));
	}
	
	private List createListA() {
		List<LinkedListNode> listA = new LinkedList<LinkedListNode>();
		LinkedListNode ln1 = new LinkedListNode(7);
		LinkedListNode ln2 = new LinkedListNode(14);
		ln1.next = ln2;
		LinkedListNode ln3 = new LinkedListNode(21);
		ln2.next = ln3;
		LinkedListNode ln4 = new LinkedListNode(28);
		ln3.next = ln4;
		LinkedListNode ln5 = new LinkedListNode(null);
		ln4.next = ln5;
		listA.add(ln1);
		listA.add(ln2);
		listA.add(ln3);
		listA.add(ln4);
		listA.add(ln5);
		
		LinkedListNode rNode = reverseIterative(listA.get(0));
		System.out.println(rNode.data);
				
		return listA;
		
		
	}
	
	private LinkedListNode reverseIterative (LinkedListNode head) {
		if( head == null || head.next == null ) {
			return head;
		}
		
		//Take next from head (this is the remainder of the list minus the head.
		LinkedListNode list_to_do = head.next;
		
		//Start new list with just the head and no next.
		LinkedListNode reversed_list = head;		
		reversed_list.next = null;
		
		
		while(list_to_do.data != null) {
			LinkedListNode temp = list_to_do;
			
			//Take next from the new head (this is the remainder of the remainder minus the new head).
			list_to_do = list_to_do.next;
			
			//Take reversed list, add it to tail of reversed list.
			temp.next = reversed_list;
			//Reset reversed list as temp value. Basically, we take off the front and add to the back.
			reversed_list = temp;
		}
		return reversed_list;
	}
	
	private static class LinkedListNode {
		public Object data;
		public LinkedListNode next;
		
		public LinkedListNode(Object data) {
			this.data = data;
		}
	}
	
	

}
