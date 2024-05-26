package  com.algos.core.li07_stack;

import java.util.Stack;

import com.algos.core.li09_linkedlist.revised.SingleLinkedList;
import  com.algos.core.li30_model.ListNode;

public class ReverseLinkedListUsingStack {

	public static void main(String[] args) {
		ReverseLinkedListUsingStack obj = new ReverseLinkedListUsingStack();
		SingleLinkedList sll = new SingleLinkedList();
		
		sll.insertAfterEnd(10);
		sll.insertAfterEnd(20);
		sll.insertAfterEnd(30);
		sll.print();
		obj.reverseLinkedListUsingStack(sll);
		System.out.println();
		sll.print();
	}

	public void reverseLinkedListUsingStack(SingleLinkedList sll){
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
