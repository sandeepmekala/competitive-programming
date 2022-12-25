package edu.algos.li14_linkedlist.medium;

import edu.algos.li00_model.ListNode;
import edu.algos.li14_linkedlist._A01_SingleLinkedList;

public class L143_ReorderList {

	public static void main(String[] args) {
		L143_ReorderList obj = new L143_ReorderList();
		_A01_SingleLinkedList list = new _A01_SingleLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		
		list.print();
		obj.reorderList(list.head);
		System.out.println();
		list.print();
	}
	
	/* Problem: https://leetcode.com/problems/reorder-list/
	 * Idea: Split the list, reverse the second list and merge.
     * 
	 * */
	public void reorderList(ListNode head1) {
        if(head1.next == null || head1.next.next == null){
            return ;
        }
        ListNode slow = head1;
        ListNode fast = head1.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        
        ListNode prev = null, curr = head2;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head2 = prev;
        
        while(head1 != null && head2 != null){
            ListNode tmp1 = head1.next;
            ListNode tmp2 = head2.next;
            head1.next = head2;
            head2.next = tmp1;
            
            head1 = tmp1;
            head2 = tmp2;
        }
    }    

}
