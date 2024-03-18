package  com.algos.li07_stack.revised;

import java.util.LinkedList;
import java.util.Queue;

public class L225_ImplementStackUsing2Queues {

	public static void main(String[] args) {
		L225_ImplementStackUsing2Queues obj = new L225_ImplementStackUsing2Queues();
		
		obj.push(1);
		obj.push(2);
		System.out.println(obj.top());
		System.out.println(obj.pop());
		System.out.println(obj.empty());
	}
	
    // Problem: https://leetcode.com/problems/implement-stack-using-queues/
    // Idea: Use two queues. Bofore inserting move all the elements to q2 and push the new element q1 and move back all the elements to q1.
	Queue<Integer> queue1;
    Queue<Integer> queue2;
    public L225_ImplementStackUsing2Queues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    } 
    
    public void push(int x) {
        while(!queue1.isEmpty())
            queue2.add(queue1.remove());
        queue1.add(x);
        while(!queue2.isEmpty())
            queue1.add(queue2.remove());
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
