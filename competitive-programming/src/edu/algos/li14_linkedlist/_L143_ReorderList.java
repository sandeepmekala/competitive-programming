package edu.algos.li14_linkedlist;

import edu.algos.li00_model.ListNode;

public class _L143_ReorderList {

	public static void main(String[] args) {
		_L143_ReorderList obj = new _L143_ReorderList();
		_G01_SingleLinkedList list = new _G01_SingleLinkedList();
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
        if(head1.next == null || head1.next.next == null)
            return ;
        
        ListNode head2 = split(head1);
        head2 = reverse(head2);
        
        ListNode curr1 = head1, curr2 = head2;
        while(curr1 != null && curr2 != null){
            ListNode tmp1 = curr1.next;
            ListNode tmp2 = curr2.next;
            curr1.next = curr2;
            curr2.next = tmp1;
            
            curr1 = tmp1;
            curr2 = tmp2;
        }
    }

    private ListNode reverse(ListNode head2) {
        ListNode prev = null, curr = head2;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head2 = prev;
        return head2;
    }

    private ListNode split(ListNode head1) {
        ListNode slow = head1;
        ListNode fast = head1.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        return head2;
    }    

}
