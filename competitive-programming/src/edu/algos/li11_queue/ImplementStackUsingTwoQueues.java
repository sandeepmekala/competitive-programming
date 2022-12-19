package edu.algos.li11_queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingTwoQueues {

	public static void main(String[] args) {
		ImplementStackUsingTwoQueues obj = new ImplementStackUsingTwoQueues();
		
		obj.push(1);
		obj.push(2);
		obj.push(3);
		System.out.println(obj.top());
		System.out.println(obj.pop());
		System.out.println(obj.empty());
	}
	
	Queue<Integer> queue1;
    public ImplementStackUsingTwoQueues() {
        queue1 = new LinkedList<>();
    }
    
    // remove and push n-1 elements to back of queue
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
