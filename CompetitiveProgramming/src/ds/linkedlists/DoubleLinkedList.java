package ds.linkedlists;

public class DoubleLinkedList {
	private Node head;
	
	public static void main(String[] args) {
		DoubleLinkedList dll = new DoubleLinkedList();

		dll.insertAtHead(10);
		dll.insertAtHead(20);
		dll.insertAtHead(30);
		dll.print();
		System.out.println();
		System.out.println("Reverse Print:");
		dll.reversePrint();
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
