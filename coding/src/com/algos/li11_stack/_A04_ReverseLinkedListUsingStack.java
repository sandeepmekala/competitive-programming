package  com.algos.li11_stack;

import java.util.Stack;

import  com.algos.li14_linkedlist._G01_SingleLinkedList;
import  com.algos.li30_model.ListNode;

public class _A04_ReverseLinkedListUsingStack {

	public static void main(String[] args) {
		_A04_ReverseLinkedListUsingStack obj = new _A04_ReverseLinkedListUsingStack();
		_G01_SingleLinkedList sll = new _G01_SingleLinkedList();
		
		sll.insertAtEnd(10);
		sll.insertAtEnd(20);
		sll.insertAtEnd(30);
		sll.print();
		obj.reverseLinkedListUsingStack(sll);
		System.out.println();
		sll.print();
	}

	public void reverseLinkedListUsingStack(_G01_SingleLinkedList sll){
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
