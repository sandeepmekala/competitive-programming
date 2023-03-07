package edu.algos.li14_linkedlist;

import edu.algos.li00_model.ListNode;

public class _L2095_DeleteTheMiddleNodeOfALinkedList {

	public static void main(String[] args) {
		_L2095_DeleteTheMiddleNodeOfALinkedList obj = new _L2095_DeleteTheMiddleNodeOfALinkedList();
		_G01_SingleLinkedList list = new _G01_SingleLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		
		list.head = obj.deleteMiddle(list.head);
		list.print();
	}

	// Problem: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
	// Idea: Fast and slow ptr's for find the middle. 
	// Use dummy node as we want to have one extra element on the right to make the delete easy..
	// 
	public ListNode deleteMiddle(ListNode head) {
        ListNode start = new ListNode();
        start.next = head;
        
        ListNode slow = start;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        
        return start.next;
    }
}
