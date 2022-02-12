package ds.queues;

public class QueueUsingLinkedListMain {

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
