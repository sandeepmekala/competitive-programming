package linkedlists;

public class SingleLinkedListMain {

	public static void main(String[] args) {
		SingleLinkedList sll = new SingleLinkedList();
		
//		sll.print();
//		sll.insertAtEnd(10);
//		System.out.println();
//		sll.print();
//		sll.insertAtEnd(20);
//		sll.insertAtEnd(30);
//		System.out.println();
//		sll.print();

//		sll.insertAtBegining(40);
//		System.out.println();
//		sll.print();
//		sll.insertAtBegining(50);
//		System.out.println();
//		sll.print();
		
		sll.insertAtNthPosition(60, 1);
		sll.insertAtNthPosition(70, 2);
		sll.insertAtNthPosition(80, 3);
		System.out.println();
		sll.print();
//		sll.deleteAtNthPosition(1);
//		System.out.println();
//		sll.print();
		sll.reverse();
		System.out.println();
		sll.print();
	}

}
