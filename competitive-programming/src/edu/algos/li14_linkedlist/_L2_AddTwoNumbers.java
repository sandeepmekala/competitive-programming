package edu.algos.li14_linkedlist;

import edu.algos.li00_model.ListNode;

public class _L2_AddTwoNumbers {

	public static void main(String[] args) {
		_L2_AddTwoNumbers obj = new _L2_AddTwoNumbers();
		_G01_SingleLinkedList list1 = new _G01_SingleLinkedList();
		list1.insertAtEnd(2);
		list1.insertAtEnd(4);
		list1.insertAtEnd(3);
		
		_G01_SingleLinkedList list2 = new _G01_SingleLinkedList();
		list2.insertAtEnd(5);
		list2.insertAtEnd(6);
		list2.insertAtEnd(4);
		
		_G01_SingleLinkedList list = new _G01_SingleLinkedList();
		list.head = obj.addTwoNumbers(list1.head, list2.head);
		list.print();
	}
 
	// Problem: https://leetcode.com/problems/add-two-numbers/
	// Idea: Use similar number addition technique.	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode head = new ListNode();
		ListNode temp = head;
		int carry = 0;
		while (l1 != null || l2 != null || carry > 0) {
			int val1 = (l1 != null)? l1.val : 0;
			int val2 = (l2 != null)? l2.val : 0;

			int sum = val1 + val2 + carry;
			ListNode newNode = new ListNode();
			newNode.val = sum % 10;
			carry = sum / 10;
			temp.next = newNode;
			
			temp = temp.next;
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}

		return head.next;
	}
}
