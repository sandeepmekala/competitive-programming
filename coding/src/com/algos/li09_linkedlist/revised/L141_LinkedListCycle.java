package  com.algos.li09_linkedlist.revised;

import  com.algos.li30_model.ListNode;

public class L141_LinkedListCycle {

	public static void main(String[] args) {
		L141_LinkedListCycle obj = new L141_LinkedListCycle();
		SingleLinkedList list = new SingleLinkedList();
		list.insertBeforeHead(3);
		list.insertAfterEnd(2);
		list.insertAfterEnd(0);
		list.insertAfterEnd(-4);
		list.head.next.next.next.next = list.head.next;
		System.out.println(obj.hasCycle(list.head));
	}
	
    // Problem: https://leetcode.com/problems/linked-list-cycle/
    // Idea: Use Floyds Cycle Detection algorithm.
    // Use slow and fast ptr's. They can meet at any node.
	public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
