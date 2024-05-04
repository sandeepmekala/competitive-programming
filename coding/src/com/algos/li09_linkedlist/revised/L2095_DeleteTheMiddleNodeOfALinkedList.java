package  com.algos.li09_linkedlist.revised;

import  com.algos.li30_model.ListNode;

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
	// Use dummy node as we want to have one extra element on the right to make the deletion easy..
	public ListNode deleteMiddle(ListNode head) {
        ListNode start = new ListNode();
        start.next = head;
        
        ListNode slow = start;
        ListNode fast = start.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        
        return start.next;
    }
}
