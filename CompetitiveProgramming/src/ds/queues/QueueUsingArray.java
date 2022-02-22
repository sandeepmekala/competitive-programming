package ds.queues;

import java.util.Arrays;

public class QueueUsingArray {
	private int max_size = 10;
	int elements[] = new int[max_size];
	private int front = -1, rear = -1;

	public void enqueue(int data){
		if(isFull()){
			System.out.println("Queue Overflow");
			return;
		}
		if(front == -1 && rear == -1){
			front = rear = 0;
		}else{
			rear = (rear + 1)%max_size;;
		}
		elements[rear] = data;
	}
	public int dequeue(){
		if(isEmpty()){
			System.out.println("queue Underflow");
			return -1;
		}
		int data = elements[front];
		if(rear == front){
			rear = front = -1;
		}else{
			front = (front + 1)%max_size;
		}
		return data;
	}
	public int front(){
		if(isEmpty()){
			System.out.println("queue Underflow");
			return -1;
		}
		return elements[front];
	}
	private boolean isEmpty(){
		if(front == -1 && rear == -1){
			return true;
		}
		return false;
	}
	private boolean isFull(){
		if((rear+1)%max_size == front){
			return true;
		}
		return false;
	}
	public void print(){
		if(isEmpty()){
			System.out.println("queue Underflow");
			return;
		}
		System.out.print(Arrays.toString(elements));
	}
	
	public static void main(String[] args) {
		QueueUsingArray queue = new QueueUsingArray();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);
		queue.enqueue(70);
		queue.enqueue(80);
		queue.enqueue(90);
		queue.enqueue(100);
		queue.enqueue(110);
		System.out.println("\nelements:");
		queue.print();
		System.out.println("\ndequeue:");
		System.out.println(queue.dequeue());
		System.out.println("\nelements:");
		queue.print();
		queue.enqueue(110);
		System.out.println("\nelements:");
		queue.print();
		System.out.println("\npeek:");
		System.out.println(queue.front());
	}
}
