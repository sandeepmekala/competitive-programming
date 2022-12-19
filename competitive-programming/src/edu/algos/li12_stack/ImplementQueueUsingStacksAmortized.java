package edu.algos.li12_stack;

import java.util.Stack;

public class ImplementQueueUsingStacksAmortized {

	public static void main(String[] args) {
		ImplementQueueUsingStacksAmortized obj = new ImplementQueueUsingStacksAmortized();
		
		obj.push(1);
		obj.push(2);
		obj.push(3);
		System.out.println(obj.peek());
		System.out.println(obj.pop());
		System.out.println(obj.empty());
	}

	Stack<Integer> stack1;
    Stack<Integer> stack2;
    public ImplementQueueUsingStacksAmortized() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        while(!stack1.isEmpty()) stack2.push(stack1.pop());
        stack1.push(x);
        while(!stack2.isEmpty()) stack1.push(stack2.pop());
    }
    
    public int pop() {
        return stack1.pop();
    }
    
    public int peek() {
        return stack1.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}
