package queues;

public class QueueUsingArray {
	private int max_size = 10;
	int elements[] = new int[max_size];
	private int front = -1, rear = -1;

	public void enqueue(int data){
		if(isFull()){
			System.out.println("Queue");
			return;
		}
		if(front == -1 && rear == -1){
			front = rear = 0;
			elements[rear] = data;
		}else{
			rear++;
		}
		elements[rear] = data;
	}
	public int dequeue(){
		if(isEmpty()){
			System.out.println("queue is empty");
			return -1;
		}
		int data = elements[front];
		if(rear == front){
			rear = front = -1;
		}else{
			front = front + 1;
		}
		return data;
	}
	public int peek(){
		if(isEmpty()){
			System.out.println("queue is empty");
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
		if(rear == max_size - 1){
			return true;
		}
		return false;
	}
	public void print(){
		if(isEmpty()){
			System.out.println("queue is empty");
			return;
		}
		for(int i=front; i<=rear; i++){
			System.out.print(elements[i]+" ");
		}
	}
}
