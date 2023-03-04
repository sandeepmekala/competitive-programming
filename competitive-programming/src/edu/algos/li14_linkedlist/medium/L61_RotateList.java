package edu.algos.li14_linkedlist.medium;

import edu.algos.li00_model.ListNode;
import edu.algos.li14_linkedlist._A01_SingleLinkedList;

public class L61_RotateList {

	public static void main(String[] args) {
		L61_RotateList obj = new L61_RotateList();
		
		int k = 2;
		_A01_SingleLinkedList list = new _A01_SingleLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		
		list.head = obj.rotateRight(list.head, k);
		list.print();
		
	}
	
    // Problem: https://leetcode.com/problems/rotate-list/
    // Idea: Go to end and make the list circular. Then traverse again and make n-kth node head.
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        
        int n = 1;
        ListNode curr = head;       // make the list circular
        while(curr.next != null){
            n++;
            curr = curr.next;
        }
        curr.next = head;
        
        k = k%n;
        curr = head;
        for(int i=1; i<n-k; i++){
            curr = curr.next;
        }
        
        head = curr.next;
        curr.next = null;
        
        return head;
    }

}
