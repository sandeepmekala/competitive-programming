package edu.ds.queues;

import edu.ds.linkedlist.model.ListNode;

public class QueueUsingLinkedList {

	private ListNode front;
	private ListNode rear;
	QueueUsingLinkedList(){
		front = null;
		rear = null;
	}
	public void enqueue(int data){
		ListNode node = new ListNode(data);
		if(front == null && rear == null){
			front = rear = node;
		}else{
			rear.setNext(node);
			rear = node;
		}
	}
	public void dequeue(){
		if(isEmpty())
			return;
		if(front == rear){
			front = rear = null;
		}else{
			front = front.getNext();
		}
	}
	public boolean isEmpty(){
		if(front == null)
			return true;
		return false;
	}
	public void print(){
		ListNode temp = front;
		while(temp != null){
			System.out.print(temp.getVal()+" ");
			temp = temp.getNext();
		}
	}
	
	public static void main(String[] args) {
		QueueUsingLinkedList queue = new QueueUsingLinkedList();
		
		queue.enqueue(10);
		queue.enqueue(20);
		System.out.println("\nelements:");
		queue.print();
		queue.dequeue();
		System.out.println("\nelements:");
		queue.print();
		queue.dequeue();
		System.out.println("\nelements:");
		queue.print();
		System.out.println(queue.isEmpty());
	}
}
