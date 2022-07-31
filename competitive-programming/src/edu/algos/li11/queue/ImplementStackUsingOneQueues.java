package edu.algos.li11.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingOneQueues {

	public static void main(String[] args) {
		ImplementStackUsingOneQueues obj = new ImplementStackUsingOneQueues();
		
		obj.push(1);
		obj.push(2);
		System.out.println(obj.top());
		System.out.println(obj.pop());
		System.out.println(obj.empty());
	}
	
	Queue<Integer> queue1;
    Queue<Integer> queue2;
    public ImplementStackUsingOneQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
    	queue2.add(x);
        while(!queue1.isEmpty()){
            queue2.add(queue1.remove());
        }
        
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
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
