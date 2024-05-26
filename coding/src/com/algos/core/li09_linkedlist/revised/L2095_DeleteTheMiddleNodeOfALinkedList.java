package  com.algos.core.li09_linkedlist.revised;

import  com.algos.core.li30_model.ListNode;

public class L2095_DeleteTheMiddleNodeOfALinkedList {

	public static void main(String[] args) {
		L2095_DeleteTheMiddleNodeOfALinkedList obj = new L2095_DeleteTheMiddleNodeOfALinkedList();
		SingleLinkedList list = new SingleLinkedList();
		list.insertAfterEnd(1);
		list.insertAfterEnd(2);
		list.insertAfterEnd(3);
		list.insertAfterEnd(4);
		list.insertAfterEnd(5);
		
		list.head = obj.deleteMiddle(list.head);
		list.print();
	}

	// Problem: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
	// Idea: Fast and slow ptr's for find the middle. 
	// We need to skip one step to slow to make it stop one element before middle. 
	// Hence we will execute one step for fast before starting the loop.
	public ListNode deleteMiddle(ListNode head) {
		if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
		fast = fast.next.next;	// Skip one step to slow
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        
        return head;
    }
}
