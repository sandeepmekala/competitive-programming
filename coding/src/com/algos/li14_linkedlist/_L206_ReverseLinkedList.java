package  com.algos.li14_linkedlist;

import  com.algos.li30_model.ListNode;

public class _L206_ReverseLinkedList {

	public static void main(String[] args) {
		_L206_ReverseLinkedList obj = new _L206_ReverseLinkedList();
		_G01_SingleLinkedList list = new _G01_SingleLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.print();
		
		ListNode head = obj.reverseList(list.head);
		list.head = head;
		System.out.println();
		list.print();

	}
	
	// Problem: https://leetcode.com/problems/reverse-linked-list/
	// Idea: Use prev, curr and next ptr's
	public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
		
        return prev;
    }

}
