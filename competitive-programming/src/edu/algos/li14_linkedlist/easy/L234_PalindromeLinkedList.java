package edu.algos.li14_linkedlist.easy;

import edu.algos.li00_model.ListNode;

public class L234_PalindromeLinkedList {

	public static void main(String[] args) {
		
	}
	
    // Problem: https://leetcode.com/problems/palindrome-linked-list/
    // Idea: Split the linked list and reverse the second half and compare both the half elements one by one.
    // While splitting left half will have one extra element incase odd elements in list.
    // In case you want one extra element in right half use dummy node.
	public boolean isPalindrome(ListNode head1) {
        ListNode middle = split(head1);
        ListNode head2 = reverse(middle);
        while(head1 != null && head2 != null){
            if(head1.val != head2.val){   
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return true;
    }
    
    private ListNode split(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = slow.next;
        slow.next = null;
        return head2;        
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
