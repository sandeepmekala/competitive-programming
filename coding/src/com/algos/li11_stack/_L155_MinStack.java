package  com.algos.li11_stack;

import java.util.Stack;

public class _L155_MinStack {

	public static void main(String[] args) {
		_L155_MinStack obj = new _L155_MinStack();
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
    // Use another stack which tracks the min till every element. While push of element, min stack pushes min(curr, peek) which will become min till that element.
	Stack<Integer> stack;
    Stack<Integer> minStack;
    public _L155_MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
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
