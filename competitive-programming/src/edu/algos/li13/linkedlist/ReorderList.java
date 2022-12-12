package edu.algos.li13.linkedlist;

import edu.algos.li00_model.ListNode;

public class ReorderList {

	public static void main(String[] args) {
		ReorderList obj = new ReorderList();
		SingleLinkedList list = new SingleLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		
		list.print();
		obj.reorderList(list.head);
		System.out.println();
		list.print();
	}
	
	/* https://leetcode.com/problems/reorder-list/
	 * 
	 * */
	public void reorderList(ListNode head) {
        if(head.next == null || head.next.next == null){
            return ;
        }
        ListNode slow = head;
        ListNode fast = head.next;
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
        
        ListNode head1 = head;
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
