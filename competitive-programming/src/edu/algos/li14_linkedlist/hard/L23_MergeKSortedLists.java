package edu.algos.li14_linkedlist.hard;

import edu.algos.li00_model.ListNode;
import edu.algos.li14_linkedlist._A01_SingleLinkedList;

public class L23_MergeKSortedLists {

	public static void main(String[] args) {
		L23_MergeKSortedLists obj = new L23_MergeKSortedLists();
		
		ListNode[] lists = new ListNode[3];
		_A01_SingleLinkedList l1 = new _A01_SingleLinkedList();
		l1.insertAtEnd(1);
		l1.insertAtEnd(4);
		l1.insertAtEnd(5);
		lists[0] = l1.head;
		
		_A01_SingleLinkedList l2 = new _A01_SingleLinkedList();
		l2.insertAtEnd(1);
		l2.insertAtEnd(3);
		l2.insertAtEnd(4);
		lists[1] = l2.head;
		
		_A01_SingleLinkedList l3 = new _A01_SingleLinkedList();
		l3.insertAtEnd(2);
		l3.insertAtEnd(6);
		lists[2] = l3.head;
		
		ListNode merged = obj.mergeKLists(lists);
		l1.head = merged;
		l1.print();

	}

	// Problem: https://leetcode.com/problems/merge-k-sorted-lists/
	// Idea: Use merge of 2 list technique. Divide the lists in n/2 groups and merge them.
	// Continue the same until only in list remains
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        
        while(lists.length > 1){
            int n = lists.length;
            ListNode[] merged = new ListNode[(int)Math.ceil(n/2.0)];
            for(int i=0; i<n; i=i+2){
                ListNode l1 = lists[i];
                if(i+1<n){
                    ListNode l2 = lists[i+1];
                    l1 = merge(l1, l2);
                }
                merged[i/2] = l1;
            }
            lists = merged;
        }
        
        return lists[0];
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {
		ListNode newHead = new ListNode(-1);
		ListNode temp = newHead;
		while(head1 != null && head2 != null) {
			if(head1.val < head2.val) {
				temp.next = head1;
				head1 = head1.next;
			}else {
				temp.next = head2;
				head2 = head2.next;
			}
			temp = temp.next;
		}
		while(head1 != null) {
			temp.next = head1;
			temp = temp.next;
			head1 = head1.next;
		}
		while(head2 != null) {
			temp.next = head2;
			temp = temp.next;
			head2 = head2.next;
		}
		return newHead.next;
		
	}
}
