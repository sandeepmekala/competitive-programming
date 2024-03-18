package  com.algos.li09_linkedlist.revised;

import  com.algos.li30_model.ListNode;

public class L21_MergeTwoSortedLists {
    public static void main(String[] args) {
        
    }
    
    // Problem: https://leetcode.com/problems/merge-two-sorted-lists/
    // Idea: Similar technique as mergin arrays.
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode start = new ListNode(-1);
		ListNode temp = start;
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
		return start.next;
    }
}
