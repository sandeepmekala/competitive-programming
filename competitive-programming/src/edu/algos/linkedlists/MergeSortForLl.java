package edu.algos.linkedlists;

import edu.algos.model.ListNode;

public class MergeSortForLl {

	static SingleLinkedList sll = new SingleLinkedList();
	public static void main(String[] args) {
		sll.insertAtEnd(7);
		sll.insertAtEnd(10);
		sll.insertAtEnd(5);
		sll.insertAtEnd(20);
		sll.insertAtEnd(3);
		sll.insertAtEnd(2);
		
		ListNode newHead = mergeSort(sll.head);
		sll.head = newHead;
		sll.print();
		
	}
	private static ListNode mergeSort(ListNode node){
		ListNode head1 = node;
		if(node == null || node.next == null) {
			return node;
		}
		ListNode head2 = splitLinkedList(node);
		
		ListNode neaHead1 = mergeSort(head1);
		ListNode neaHead2 = mergeSort(head2);
		ListNode neaHead = merge(neaHead1, neaHead2);
		return neaHead;
	}
	private static ListNode merge(ListNode head1, ListNode head2) {
		ListNode newHead = new ListNode(-1);
		ListNode temp = newHead;
		while(head1 != null && head2 != null) {
			if(head1.getVal() < head2.getVal()) {
				temp.next = head1;
				head1 = head1.next;
			}else {
				temp.next = head2;
				head2 = head2.next;
			}
			temp = temp.next;
		}
		while(head1 != null) {
			temp.next = head1;
			temp = temp.next;
			head1 = head1.next;
		}
		while(head2 != null) {
			temp.next = head2;
			temp = temp.next;
			head2 = head2.next;
		}
		return newHead.next;
		
	}
	
	private static ListNode splitLinkedList(ListNode head) {
		ListNode slowPtr = head;
		ListNode fastPtr = head.next;
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		ListNode head2 = slowPtr.next;
		slowPtr.next = (null);
		return head2;
	}
}
