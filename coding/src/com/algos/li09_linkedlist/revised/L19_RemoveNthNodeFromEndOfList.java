package com.algos.li09_linkedlist.revised;

import com.algos.li30_model.ListNode;

public class L19_RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		L19_RemoveNthNodeFromEndOfList obj = new L19_RemoveNthNodeFromEndOfList();
		SingleLinkedList list = new SingleLinkedList();
		list.insertAfterEnd(1);
		list.insertAfterEnd(2);
		list.insertAfterEnd(3);
		list.insertAfterEnd(4);
		
		list.head = obj.removeNthFromEnd(list.head, 4);
		list.print();
	}
	
    // Problem: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    // Idea: First move right ptr to n nodes. Then move both left and right ptr till right.right is null.
    // Now the left node which was pointing head node, points to n+1th node fron last. Remove nth node.
	public ListNode removeNthFromEnd(ListNode head, int n) {    
        ListNode left = head;
        ListNode right = head;
        for (int cnt = 0; cnt < n; cnt++)
            right = right.next;
        
        if(right == null)       // remove head case
            return head.next;
        
        while(right.next != null){
            left = left.next;
            right = right.next;
        }
        
        left.next = left.next.next;
        return head;
    }

}
