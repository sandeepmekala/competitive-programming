package edu.algos.li12.stack;

import java.util.Stack;

public class ImplementQueueUsingStacks {

	public static void main(String[] args) {
		ImplementQueueUsingStacks obj = new ImplementQueueUsingStacks();
		
		obj.push(1);
		obj.push(2);
		obj.push(3);
		System.out.println(obj.peek());
		System.out.println(obj.pop());
		System.out.println(obj.empty());
	}

	Stack<Integer> inputStack;
    Stack<Integer> outputStack;
    public ImplementQueueUsingStacks() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    
    public void push(int x) {
        inputStack.push(x);
    }
    
    public int pop() {
    	if(outputStack.isEmpty()) 
    		while(!inputStack.isEmpty()) 
    			outputStack.push(inputStack.pop());
        return outputStack.pop();
    }
    
    public int peek() {
    	if(outputStack.isEmpty()) 
    		while(!inputStack.isEmpty()) 
    			outputStack.push(inputStack.pop());
        return outputStack.peek();
    }
    
    public boolean empty() {
    	return inputStack.isEmpty() && outputStack.isEmpty();
    }
}
