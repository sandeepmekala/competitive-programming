package ds.queues;

public class QueueUsingArrayMain {

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
