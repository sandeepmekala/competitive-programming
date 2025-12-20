import com.algos.topics.models.ListNode;

public class A02_QueueUsingLinkedList {

	private ListNode front;
	private ListNode rear;
	A02_QueueUsingLinkedList(){
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

	public int dequeue(){
		if(isEmpty())
			return -1;

		int data = front.val;
		if(front == rear){
			front = rear = null;
		}else{
			front = front.getNext();
		}

		return data;
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
		A02_QueueUsingLinkedList queue = new A02_QueueUsingLinkedList();

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
