package edu.algos.li14_linkedlist;

import edu.algos.li30_model.ListNode;

public class _L83_RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		_L83_RemoveDuplicatesFromSortedList obj = new _L83_RemoveDuplicatesFromSortedList();
		
		_G01_SingleLinkedList list = new _G01_SingleLinkedList();
		list.insertAtEnd(2);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		
		list.head = obj.deleteDuplicates(list.head);
		list.print();
	}
	
	// Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
	// Idea: Compare curr and curr.next vals, if equal, change curr.next to curr.next.next.
	public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        
        return head;
    }

}
