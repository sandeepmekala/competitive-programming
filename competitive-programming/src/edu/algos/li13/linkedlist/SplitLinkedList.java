package edu.algos.li13.linkedlist;

import edu.algos.li00.model.ListNode;

public class SplitLinkedList {

	static SingleLinkedList sll = new SingleLinkedList();
	public static void main(String[] args) {
		sll.insertAtEnd(7);
		sll.insertAtEnd(10);
		sll.insertAtEnd(5);
		sll.insertAtEnd(20);
		sll.insertAtEnd(3);
		sll.insertAtEnd(2);
		
	
		ListNode head2 = splitLinkedList(sll.head);
		ListNode head1 = sll.head;
		sll.print();
		
		System.out.println();
		sll.head = head2;
		sll.print();
	}
	
	private static ListNode splitLinkedList(ListNode head) {
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
