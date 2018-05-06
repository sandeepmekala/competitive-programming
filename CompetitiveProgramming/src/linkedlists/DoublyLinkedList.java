package linkedlists;

public class DoublyLinkedList {
	private Node head;
	
	DoublyLinkedList(){
		head = null;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	public void insertAtHead(int data){
		Node node = new Node(data);
		if(head == null){
			head = node;
			return;
		}
		head.setPrev(node);
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
	public void reversePrint(){
		if(head == null){
			System.out.println("List is empty");
		}
		Node temp = head;
		while(temp.getNext() != null){
			temp = temp.getNext();
		}
		while(temp != null){
			System.out.print(temp.getData()+" ");
			temp = temp.getPrev();
		}
	}
}
