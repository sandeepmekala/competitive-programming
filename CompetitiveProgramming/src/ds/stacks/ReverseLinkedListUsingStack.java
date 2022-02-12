package ds.stacks;

import java.util.Stack;

import ds.linkedlists.Node;
import ds.linkedlists.SinglyLinkedList;

public class ReverseLinkedListUsingStack {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		
		sll.insertAtEnd(10);
		sll.insertAtEnd(20);
		sll.insertAtEnd(30);
		sll.print();
		reverseLinkedListUsingStack(sll);
		System.out.println();
		sll.print();
		
	}
	private static void reverseLinkedListUsingStack(SinglyLinkedList sll){
		Stack<Node> stack = new Stack<Node>();
		
		Node temp = sll.getHead();
		while(temp != null){
			stack.push(temp);
			temp = temp.getNext();
		}
		
		Node temp1 = stack.pop();
		sll.setHead(temp1);
		while(!stack.isEmpty()){
			temp1.setNext(stack.pop());
			temp1 = temp1.getNext();
		}
		temp1.setNext(null);
	}

}
