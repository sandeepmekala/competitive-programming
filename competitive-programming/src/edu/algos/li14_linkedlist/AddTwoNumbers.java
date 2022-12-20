package edu.algos.li14_linkedlist;

import edu.algos.li00_model.ListNode;

public class AddTwoNumbers {

	public static void main(String[] args) {
		AddTwoNumbers obj = new AddTwoNumbers();
		SingleLinkedList list1 = new SingleLinkedList();
		list1.insertAtEnd(2);
		list1.insertAtEnd(4);
		list1.insertAtEnd(3);
		
		SingleLinkedList list2 = new SingleLinkedList();
		list2.insertAtEnd(5);
		list2.insertAtEnd(6);
		list2.insertAtEnd(4);
		
		SingleLinkedList list = new SingleLinkedList();
		list.head = obj.addTwoNumbers(list1.head, list2.head);
		list.print();
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode head = new ListNode();
		ListNode temp = head;
		int carry = 0;
		while (l1 != null || l2 != null || carry > 0) {
			int val1 = 0, val2 = 0;
			if (l1 != null) {
				val1 = l1.val;
			}
			if (l2 != null) {
				val2 = l2.val;
			}
			int sum = val1 + val2 + carry;
			ListNode newNode = new ListNode();
			newNode.val = sum % 10;
			carry = sum / 10;
			temp.next = newNode;

			temp = temp.next;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}

		return head.next;
	}
}
