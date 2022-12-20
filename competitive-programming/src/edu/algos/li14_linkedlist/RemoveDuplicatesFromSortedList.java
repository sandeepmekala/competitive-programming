package edu.algos.li14_linkedlist;

import edu.algos.li00_model.ListNode;

public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList obj = new RemoveDuplicatesFromSortedList();
		
		SingleLinkedList list = new SingleLinkedList();
		list.insertAtEnd(2);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		
		list.head = obj.deleteDuplicates(list.head);
		list.print();
	}
	
	/*
	 * Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
	 * */
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
