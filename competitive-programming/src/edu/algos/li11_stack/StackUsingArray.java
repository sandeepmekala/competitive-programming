package edu.algos.li11_stack;

public class StackUsingArray {
	
	private int max_size = 101;
	private int elements[] = new int[max_size];
	private int top = -1;
	
	public void push(int data){
		if(top == max_size-1){
			System.out.println("Error: Stack Overflow");
			return;
		}
		elements[++top] = data;
	}
	public void pop(){
		if(top == -1){
			System.out.println("Error: Stack Underflows");
			return;
		}
		top--;
	}
	public int top(){
		if(top == -1){
			System.out.println("Error: Stack Underflows");
			return -1;
		}
		return elements[top];
	}
	public void isEmpty(){
		if(top == -1){
			System.out.println("Stack is empty");
		}
	}
	public void print(){
		System.out.println();
		for(int i=0; i<=top; i++){
			System.out.print(elements[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		StackUsingArray stack = new StackUsingArray();
		
		stack.push(10);
		stack.print();
		stack.push(20);
		stack.print();
		stack.push(30);
		stack.print();
		stack.pop();
		stack.print();
		System.out.println("\n"+stack.top());
		stack.print();

	}
}
