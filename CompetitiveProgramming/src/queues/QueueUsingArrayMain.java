package queues;

public class QueueUsingArrayMain {

	public static void main(String[] args) {
		QueueUsingArray queue = new QueueUsingArray();
		queue.enqueue(10);
		queue.enqueue(20);
		System.out.println("\nelements:");
		queue.print();
		System.out.println("\ndequeue:");
		System.out.println(queue.dequeue());
		System.out.println("\nelements:");
		queue.print();
		System.out.println("\npeek:");
		System.out.println(queue.peek());
	}
}
