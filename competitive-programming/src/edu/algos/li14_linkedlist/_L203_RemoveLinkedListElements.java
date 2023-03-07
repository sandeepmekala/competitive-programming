package edu.algos.li14_linkedlist;

import edu.algos.li00_model.ListNode;

public class _L203_RemoveLinkedListElements {

	public static void main(String[] args) {
		_L203_RemoveLinkedListElements obj = new _L203_RemoveLinkedListElements();
		
		_G01_SingleLinkedList list = new _G01_SingleLinkedList();
		list.insertAtEnd(2);
		list.insertAtEnd(4);
		list.insertAtEnd(3);
		list.insertAtEnd(2);
		
		list.head = obj.removeElements(list.head, 2);
		list.print();		
	}

	/*
	 * Problem: https://leetcode.com/problems/remove-linked-list-elements/
	 * Idea: We might have to remove head also. To simplify that add dummy node.
	 * If curr.next is val, then adjust curr.next = curr.next.next.
	 * 
	 * */
	public ListNode removeElements(ListNode head, int val) {
        ListNode start = new ListNode();
        start.next = head ; 

        ListNode curr = start;
        while(curr != null && curr.next != null){
            if(curr.next.val == val)
                curr.next = curr.next.next;
            else curr = curr.next;
        }
        
        return start.next;
    }
}
