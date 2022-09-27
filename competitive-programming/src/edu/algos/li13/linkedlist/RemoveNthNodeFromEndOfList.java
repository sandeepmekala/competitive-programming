package edu.algos.li13.linkedlist;

import edu.algos.li00.model.ListNode;

public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		RemoveNthNodeFromEndOfList obj = new RemoveNthNodeFromEndOfList();
		SingleLinkedList list = new SingleLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		
		obj.removeNthFromEnd(list.head, 2);
		list.print();
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode left = dummy;
        ListNode right = head;
        int cnt = 1;
        while(right != null && cnt++ <= n){
            right = right.next;
        }
        
        while(right != null){
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        
        return dummy.next;
    }

}
