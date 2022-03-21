package edu.ds.linkedlists;

import edu.ds.linkedlist.model.Node;

public class SplitLinkedList {

	static SingleLinkedList sll = new SingleLinkedList();
	public static void main(String[] args) {
		sll.insertAtEnd(7);
		sll.insertAtEnd(10);
		sll.insertAtEnd(5);
		sll.insertAtEnd(20);
		sll.insertAtEnd(3);
		sll.insertAtEnd(2);
		
	
		Node head2 = splitLinkedList(sll.getHead());
		
		Node head1 = sll.getHead();
		sll.print();
		
		System.out.println();
		sll.setHead(head2);
		sll.print();
		
	}
	private static Node mergeSort(Node node){
		Node head1 = node;
		if(node == null || node.getNext() == null) {
			return node;
		}
		Node head2 = splitLinkedList(node);
		
		Node neaHead1 = mergeSort(head1);
		Node neaHead2 = mergeSort(head2);
		Node neaHead = merge(neaHead1, neaHead2);
		return neaHead;
	}
	private static Node merge(Node head1, Node head2) {
		Node newHead = new Node(-1);
		Node temp = newHead;
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
	
	private static Node splitLinkedList(Node head) {
		Node slowPtr = head;
		Node fastPtr = head.getNext();
		while(fastPtr != null && fastPtr.getNext() != null) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
		}
		Node head2 = slowPtr.getNext();
		slowPtr.setNext(null);
		return head2;
	}
}
