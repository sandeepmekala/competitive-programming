package  com.algos.core.li07_stack.revised;

import java.util.Stack;

public class L155_MinStack {

	public static void main(String[] args) {
		L155_MinStack obj = new L155_MinStack();
		obj.push(-2);
		obj.push(0);
		obj.push(-3);
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());
	}

    // Problem: https://leetcode.com/problems/min-stack/ 
    // Idea: Idea is simple. Use 2 stack. One normal stack to support normal stack operations like push, pop and peek.
    // Use another stack which tracks the min till every element. 
    // While pushing of element, min stack pushes min(curr, peek) which will become min till that element.
	Stack<Integer> stack;
    Stack<Integer> minStack;
    public L155_MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        }else{
            minStack.push(Math.min(val, minStack.peek()));
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
