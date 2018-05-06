package linkedlists;

public class DoublyLinkedListMain {

	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();

		dll.insertAtHead(10);
		dll.insertAtHead(20);
		dll.insertAtHead(30);
		dll.print();
		System.out.println();
		System.out.println("Reverse Print:");
		dll.reversePrint();
	}

}
