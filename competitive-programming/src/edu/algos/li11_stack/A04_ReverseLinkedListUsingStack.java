package edu.algos.li11_stack;

import java.util.Stack;

import edu.algos.li00_model.ListNode;
import edu.algos.li14_linkedlist._A01_SingleLinkedList;

public class A04_ReverseLinkedListUsingStack {

	public static void main(String[] args) {
		A04_ReverseLinkedListUsingStack obj = new A04_ReverseLinkedListUsingStack();
		_A01_SingleLinkedList sll = new _A01_SingleLinkedList();
		
		sll.insertAtEnd(10);
		sll.insertAtEnd(20);
		sll.insertAtEnd(30);
		sll.print();
		obj.reverseLinkedListUsingStack(sll);
		System.out.println();
		sll.print();
	}

	public void reverseLinkedListUsingStack(_A01_SingleLinkedList sll){
		Stack<ListNode> stack = new Stack<ListNode>();
		
		ListNode temp = sll.head;
		while(temp != null){
			stack.push(temp);
			temp = temp.getNext();
		}
		
		ListNode temp1 = stack.pop();
		sll.head = temp1;
		while(!stack.isEmpty()){
			temp1.setNext(stack.pop());
			temp1 = temp1.getNext();
		}
		temp1.setNext(null);
	}

}
