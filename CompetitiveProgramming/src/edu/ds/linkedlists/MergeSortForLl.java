package edu.ds.linkedlists;

import edu.ds.linkedlist.model.ListNode;

public class MergeSortForLl {

	static SingleLinkedList sll = new SingleLinkedList();
	public static void main(String[] args) {
		sll.insertAtEnd(7);
		sll.insertAtEnd(10);
		sll.insertAtEnd(5);
		sll.insertAtEnd(20);
		sll.insertAtEnd(3);
		sll.insertAtEnd(2);
		
		ListNode newHead = mergeSort(sll.getHead());
		sll.setHead(newHead);
		sll.print();
		
	}
	private static ListNode mergeSort(ListNode node){
		ListNode head1 = node;
		if(node == null || node.getNext() == null) {
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
			if(head1.getData() < head2.getData()) {
				temp.setNext(head1);
				head1 = head1.getNext();
			}else {
				temp.setNext(head2);
				head2 = head2.getNext();
			}
			temp = temp.getNext();
		}
		while(head1 != null) {
			temp.setNext(head1);
			temp = temp.getNext();
			head1 = head1.getNext();
		}
		while(head2 != null) {
			temp.setNext(head2);
			temp = temp.getNext();
			head2 = head2.getNext();
		}
		return newHead.getNext();
		
	}
	
	private static ListNode splitLinkedList(ListNode head) {
		ListNode slowPtr = head;
		ListNode fastPtr = head.getNext();
		while(fastPtr != null && fastPtr.getNext() != null) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
		}
		ListNode head2 = slowPtr.getNext();
		slowPtr.setNext(null);
		return head2;
	}
}
