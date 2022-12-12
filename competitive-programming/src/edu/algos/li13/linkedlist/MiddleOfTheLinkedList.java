package edu.algos.li13.linkedlist;

import edu.algos.li00_model.ListNode;

public class MiddleOfTheLinkedList {

	public static void main(String[] args) {
		MiddleOfTheLinkedList obj = new MiddleOfTheLinkedList();
		SingleLinkedList list = new SingleLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		
		System.out.println(obj.middleNode(list.head));
	}

	public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}
