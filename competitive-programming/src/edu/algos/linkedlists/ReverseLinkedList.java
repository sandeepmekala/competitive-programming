package edu.algos.linkedlists;

import edu.algos.model.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ReverseLinkedList obj = new ReverseLinkedList();
		SingleLinkedList list = new SingleLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.print();
		
		ListNode head = obj.reverseList(list.head);
		list.head = head;
		System.out.println();
		list.print();

	}
	
	public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

}
