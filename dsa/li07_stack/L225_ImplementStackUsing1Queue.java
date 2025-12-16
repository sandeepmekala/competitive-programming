package li07_stack;

import java.util.LinkedList;
import java.util.Queue;

public class L225_ImplementStackUsing1Queue {

	public static void main(String[] args) {
		L225_ImplementStackUsing1Queue obj = new L225_ImplementStackUsing1Queue();

		obj.push(1);
		obj.push(2);
		obj.push(3);
		System.out.println(obj.top());
		System.out.println(obj.pop());
		System.out.println(obj.empty());
	}

    // Problem: https://leetcode.com/problems/implement-stack-using-queues/
    // Idea: Remove and push n-1 elements to back of queue
	Queue<Integer> queue1;
    public L225_ImplementStackUsing1Queue() {
        queue1 = new LinkedList<>();
    }

    public void push(int x) {
    	queue1.add(x);
        for(int i=0; i<queue1.size()-1; i++) {
        	queue1.add(queue1.remove());
        }
    }

    public int pop() {
        return queue1.remove();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

}
