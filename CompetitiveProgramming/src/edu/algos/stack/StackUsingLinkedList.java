package edu.algos.stack;

import edu.algos.linkedlist.model.ListNode;

public class StackUsingLinkedList {

	private ListNode top;
	StackUsingLinkedList(){
		top = null;
	}
	
	public void push(int data){
		ListNode node = new ListNode(data);
		node.setNext(top);
		top = node;
	}
	public void print(){
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
	public void pop(){
		if(top == null){
			System.out.println("Stack is empty");
			return;
		}
		top = top.getNext();
	}
	public int top(){
		if(top == null){
			System.out.println("Stack is empty");
			return -1;
		}

		return top.getVal();
	}
	public boolean isEmpty(){
		if(top == null){
			return true;
		}else{
			return false;
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
