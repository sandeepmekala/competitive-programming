package  com.algos.li14_linkedlist;

import  com.algos.li30_model.ListNode;

public class _L876_MiddleOfTheLinkedList {

	public static void main(String[] args) {
		_L876_MiddleOfTheLinkedList obj = new _L876_MiddleOfTheLinkedList();
		_G01_SingleLinkedList list = new _G01_SingleLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		
		System.out.println(obj.middleNode(list.head));
	}

	// Problem: https://leetcode.com/problems/middle-of-the-linked-list/
	// Idea: Use fast and slow pointers
	public ListNode middleNode(ListNode head) {
        ListNode slow = head,fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}
