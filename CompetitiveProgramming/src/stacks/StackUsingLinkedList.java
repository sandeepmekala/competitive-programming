package stacks;

import linkedlists.Node;

public class StackUsingLinkedList {

	private Node top;
	StackUsingLinkedList(){
		top = null;
	}
	
	public void push(int data){
		Node node = new Node(data);
		node.setNext(top);
		top = node;
	}
	public void print(){
		if(top == null){
			System.out.println("stack is empty");
			return;
		}
		Node temp = top;
		while(temp !=  null){
			System.out.print(temp.getData()+" ");
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

		return top.getData();
	}
	public boolean isEmpty(){
		if(top == null){
			return true;
		}else{
			return false;
		}
	}
}
