package linkedlists;

public class SinglyLinkedList {

	private Node head;
	SinglyLinkedList(){
		head = null;
	}
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void insertAtEnd(int data){
		if(head == null){
			Node node = new Node();
			node.setData(data);
			head = node;
			return;
		}
		Node temp = head;
		while(temp.getNext()!= null){
			temp = temp.getNext();
		}
		
		temp.setNext(new Node(data));
		
	}
	public void insertAtBegining(int data){
		Node node = new Node();
		node.setData(data);
		node.setNext(head);
		head = node;
	}
	public void print(){
		if(head == null){
			System.out.println("List is empty");
			return;
		}
		
		Node temp = head;
		while(temp != null){
			System.out.print(temp.getData()+" ");
			temp = temp.getNext();
		}
	}
	public void insertAtNthPosition(int data, int n){
		Node node  = new Node(data);
		if(n == 1){
			head = node;
			return;
		}
		Node temp = head;
		for(int i=0; i<n-2; i++){
			temp = temp.getNext();
		}
		node.setNext(temp.getNext());
		temp.setNext(node);
	}
	public void deleteAtNthPosition(int n){
		Node temp = head;
		if(n == 1){
			head = head.getNext();
			return;
		}
		for(int i=0; i<n-2; i++){
			temp = temp.getNext();
		}

		temp.setNext(temp.getNext().getNext());
	}
	public void reverse(){
		Node prev = null, current = null, next;
		current = head;
		while(current != null){
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		head = prev;
	}
	public void recursivePrint(Node node){
		if(node == null){
			return;
		}
		System.out.print(node.getData()+" ");
		recursivePrint(node.getNext());
	}
	public void recursiveReversePrint(Node node){
		if(node == null){
			return;
		}
		recursiveReversePrint(node.getNext());
		System.out.print(node.getData()+" ");
	}
	public void recursiveReveres(Node node){
		if(node.getNext() == null){
			head = node;
			return;
		}
		recursiveReveres(node.getNext());
		Node temp = node.getNext();
		temp.setNext(node);
		node.setNext(null);
	}
}