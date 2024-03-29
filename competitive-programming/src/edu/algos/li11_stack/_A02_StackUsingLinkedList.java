package edu.algos.li11_stack;

import edu.algos.li00_model.ListNode;

public class _A02_StackUsingLinkedList {

	private ListNode top;
	_A02_StackUsingLinkedList(){
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
		_A02_StackUsingLinkedList stack = new _A02_StackUsingLinkedList();
		
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
