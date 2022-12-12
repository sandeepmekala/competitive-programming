package edu.algos.li13.linkedlist;

import edu.algos.li00_model.ListNode;

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		RemoveLinkedListElements obj = new RemoveLinkedListElements();
		
		SingleLinkedList list = new SingleLinkedList();
		list.insertAtEnd(2);
		list.insertAtEnd(4);
		list.insertAtEnd(3);
		list.insertAtEnd(2);
		
		list.head = obj.removeElements(list.head, 2);
		list.print();		
	}

	/*
	 * Problem: https://leetcode.com/problems/remove-linked-list-elements/
	 * */
	public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head ; 
        ListNode curr = dummy;
        while(curr != null && curr.next != null){
            if(curr.next.val == val)
                curr.next = curr.next.next;
            else curr = curr.next;
        }
        
        return dummy.next;
    }
}
