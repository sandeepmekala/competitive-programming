package linkedlists;

public class SinglyLinkedListMain {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		
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
		System.out.println("\n\n");
		sll.recursivePrint(sll.getHead());
		System.out.println();
		sll.recursiveReversePrint(sll.getHead());
		System.out.println();
		System.out.println("Recusrcive reverse:");
		sll.print();
		sll.recursiveReveres(sll.getHead());
		System.out.println();
		sll.print();
		
	}

}
