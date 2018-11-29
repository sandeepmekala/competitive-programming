package queues;

import linkedlists.Node;

public class QueueUsingLinkedList {

	private Node front;
	private Node rear;
	QueueUsingLinkedList(){
		front = null;
		rear = null;
	}
	public void enqueue(int data){
		Node node = new Node(data);
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
		Node temp = front;
		while(temp != null){
			System.out.print(temp.getData()+" ");
			temp = temp.getNext();
		}
	}
}
