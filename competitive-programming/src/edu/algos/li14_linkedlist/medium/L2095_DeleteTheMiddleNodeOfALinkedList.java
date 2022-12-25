package edu.algos.li14_linkedlist.medium;

import edu.algos.li00_model.ListNode;
import edu.algos.li14_linkedlist._A01_SingleLinkedList;

public class L2095_DeleteTheMiddleNodeOfALinkedList {

	public static void main(String[] args) {
		L2095_DeleteTheMiddleNodeOfALinkedList obj = new L2095_DeleteTheMiddleNodeOfALinkedList();
		_A01_SingleLinkedList list = new _A01_SingleLinkedList();
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
