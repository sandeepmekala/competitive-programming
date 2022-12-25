package edu.algos.li14_linkedlist;

import edu.algos.li00_model.ListNode;

public class A03_SplitLinkedList {

	static _A01_SingleLinkedList sll = new _A01_SingleLinkedList();
	public static void main(String[] args) {
		A03_SplitLinkedList obj = new A03_SplitLinkedList();

		sll.insertAtEnd(7);
		sll.insertAtEnd(10);
		sll.insertAtEnd(5);
		sll.insertAtEnd(15);
		sll.insertAtEnd(20);
		sll.insertAtEnd(3);
		sll.insertAtEnd(2);
		
	
		ListNode head2 = obj.splitLinkedList(sll.head);
		ListNode head1 = sll.head;
		sll.print();
		
		System.out.println();
		sll.head = head2;
		sll.print();
	}
	
	// While splitting left half will have one extra element incase odd elements in list.
	// In case you want one extra element in right half use dummy node.
	private ListNode splitLinkedList(ListNode head) {
		ListNode slowPtr = head;
		ListNode fastPtr = head.next;
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}

		ListNode head2 = slowPtr.next;
		slowPtr.setNext(null);
		return head2;
	}
}
