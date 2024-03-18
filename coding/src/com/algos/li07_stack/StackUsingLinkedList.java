package  com.algos.li07_stack;

import  com.algos.li30_model.ListNode;

public class StackUsingLinkedList {

	private ListNode top;
	StackUsingLinkedList(){
		top = null;
	}
	
	private void push(int data){
		ListNode node = new ListNode(data);
		node.setNext(top);
		top = node;
	}

	private void pop(){
		if(top == null){
			System.out.println("Stack is empty");
			return;
		}
		top = top.getNext();
	}

	private int top(){
		if(top == null){
			System.out.println("Stack is empty");
			return -1;
		}

		return top.getVal();
	}

	private boolean isEmpty(){
		if(top == null){
			return true;
		}else{
			return false;
		}
	}

	private void print(){
		if(top == null){
			System.out.println("stack is empty");
			return;
		}
		ListNode temp = top;
		while(temp !=  null){
			System.out.print(temp.getVal()+" ");
			temp = temp.getNext();
		}
	}

	public static void main(String[] args) {
		StackUsingLinkedList stack = new StackUsingLinkedList();
		
		stack.push(10);
		System.out.println();
		stack.print();
		stack.push(20);
		System.out.println();
		stack.print();
		stack.push(30);
		System.out.println();
		stack.print();
		stack.pop();
		System.out.println();
		stack.print();
		System.out.println("\nPrinting top element:");
		System.out.println(stack.top());
		stack.print();
		System.out.println("\nChecking if stack is empty:");
		System.out.println(stack.isEmpty());
	}
}
