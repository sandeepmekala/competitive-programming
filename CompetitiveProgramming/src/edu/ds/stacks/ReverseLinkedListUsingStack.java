package edu.ds.stacks;

import java.util.Stack;

import edu.ds.linkedlist.model.ListNode;
import edu.ds.linkedlists.SingleLinkedList;

public class ReverseLinkedListUsingStack {

	public static void main(String[] args) {
		SingleLinkedList sll = new SingleLinkedList();
		
		sll.insertAtEnd(10);
		sll.insertAtEnd(20);
		sll.insertAtEnd(30);
		sll.print();
		reverseLinkedListUsingStack(sll);
		System.out.println();
		sll.print();
		
	}
	private static void reverseLinkedListUsingStack(SingleLinkedList sll){
		Stack<ListNode> stack = new Stack<ListNode>();
		
		ListNode temp = sll.getHead();
		while(temp != null){
			stack.push(temp);
			temp = temp.getNext();
		}
		
		ListNode temp1 = stack.pop();
		sll.setHead(temp1);
		while(!stack.isEmpty()){
			temp1.setNext(stack.pop());
			temp1 = temp1.getNext();
		}
		temp1.setNext(null);
	}

}
