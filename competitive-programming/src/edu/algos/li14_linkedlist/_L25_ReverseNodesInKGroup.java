package edu.algos.li14_linkedlist;

import edu.algos.li00_model.ListNode;

public class _L25_ReverseNodesInKGroup {

	public static void main(String[] args) {
		_L25_ReverseNodesInKGroup obj = new _L25_ReverseNodesInKGroup();
		_G01_SingleLinkedList list = new _G01_SingleLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		
		ListNode head = obj.reverseKGroup(list.head, 3);
		list.head = head;
		list.print();
	}
	
	// Problem: https://leetcode.com/problems/reverse-nodes-in-k-group/
	// Idea: We need to track last of previous group. Hence, add a dummy node and treat it as prev group last.
	// We need to track curr group first which will become last after reverse and it will become previous group last once this group is processed.
	// 
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1)
            return head;

        int length = getLength(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = null, curr = head;
        ListNode prevGroupLast = dummy, currGroupLast = null;
        while(length >= k){
            for(int i=0; i<k; i++) {
            	if(i == 0) currGroupLast = curr;
            	
            	ListNode next = curr.next;
        		curr.next = prev;
        		prev = curr;
        		curr = next;
            }
            prevGroupLast.next = prev;
            prevGroupLast = currGroupLast;
            length -= k;
        }
        prevGroupLast.next = curr;
        
        return dummy.next;
    }
	
	private int getLength(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while(temp != null) {
        	length++;
        	temp = temp.next;
        }
        return length;
	}

}
