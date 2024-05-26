package  com.algos.core.li08_queue.revised;

import java.util.Stack;

public class L232_ImplementQueueUsingStacks {

	public static void main(String[] args) {
		L232_ImplementQueueUsingStacks obj = new L232_ImplementQueueUsingStacks();
		
		obj.push(1);
		obj.push(2);
		obj.push(3);
		System.out.println(obj.peek());
		System.out.println(obj.pop());
		System.out.println(obj.empty());
	}

	// Problem: https://leetcode.com/problems/implement-queue-using-stacks/
	// Idea: Use two stacks. s1->s2, s1.push(x), s2->s1.
    // Alternative to achieve O(1) armotized complexity. Use two stacks. input and output. Push elements to input stack and pop elements from output stack.
	// If output stack is empty move all the elements from input stack to output stack.
	Stack<Integer> stack1;
    Stack<Integer> stack2;
    public L232_ImplementQueueUsingStacks() {
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
