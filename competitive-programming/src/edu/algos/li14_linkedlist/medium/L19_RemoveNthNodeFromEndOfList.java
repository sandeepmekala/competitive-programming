package edu.algos.li14_linkedlist.medium;

import edu.algos.li00_model.ListNode;
import edu.algos.li14_linkedlist._A01_SingleLinkedList;

public class L19_RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		L19_RemoveNthNodeFromEndOfList obj = new L19_RemoveNthNodeFromEndOfList();
		_A01_SingleLinkedList list = new _A01_SingleLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		
		obj.removeNthFromEnd(list.head, 2);
		list.print();
	}
	
    // Problem: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    // Idea: We might have to remove head also. Hence add dummy node.
    // First move right ptr ton nodes. Then move both left and right ptr till right is null.
    // Now the left node which was pointing dummy node, points to n+1th node fron last. Remove nth node.
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode left = dummy;
        ListNode right = head;
        int cnt = 1;
        while(right != null && cnt++ <= n){
            right = right.next;
        }
        
        while(right != null){
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        
        return dummy.next;
    }

}
