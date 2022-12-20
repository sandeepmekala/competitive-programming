package edu.algos.li14_linkedlist;

import edu.algos.li00_model.ListNode;

public class DeleteTheMiddleNodeOfALinkedList {

	public static void main(String[] args) {
		DeleteTheMiddleNodeOfALinkedList obj = new DeleteTheMiddleNodeOfALinkedList();
		SingleLinkedList list = new SingleLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		
		list.head = obj.deleteMiddle(list.head);
		list.print();
	}

	public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}
