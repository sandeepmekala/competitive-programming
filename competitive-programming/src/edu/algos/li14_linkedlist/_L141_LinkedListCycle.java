package edu.algos.li14_linkedlist;

import edu.algos.li00_model.ListNode;

public class _L141_LinkedListCycle {

	public static void main(String[] args) {
		_L141_LinkedListCycle obj = new _L141_LinkedListCycle();
		_G01_SingleLinkedList list = new _G01_SingleLinkedList();
		list.insertAtBegining(3);
		list.insertAtEnd(2);
		list.insertAtEnd(0);
		list.insertAtEnd(-4);
		list.head.next.next.next.next = list.head.next;
		System.out.println(obj.hasCycle(list.head));
	}
	
    // Problem: https://leetcode.com/problems/linked-list-cycle/
    // Idea: Use Floyds Cycle Detection algorithm.
    // Use slow and fast ptr's. They can meet at any node.
	public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
