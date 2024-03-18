package com.algos.li09_linkedlist.revised;

import com.algos.li09_linkedlist.SingleLinkedList;
import com.algos.li30_model.ListNode;

public class L19_RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		L19_RemoveNthNodeFromEndOfList obj = new L19_RemoveNthNodeFromEndOfList();
		SingleLinkedList list = new SingleLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		
		obj.removeNthFromEnd(list.head, 2);
		list.print();
	}
	
    // Problem: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    // Idea: We might have to remove head also. Hence add dummy node.
    // First move right ptr to n nodes. Then move both left and right ptr till right is null.
    // Now the left node which was pointing dummy node, points to n+1th node fron last. Remove nth node.
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;
        
        ListNode left = start, right = start;
        int cnt = 1;
        while(cnt <= n){
            right = right.next;
            cnt++;
        }
        
        while(right.next != null){
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return start.next;
    }

}
