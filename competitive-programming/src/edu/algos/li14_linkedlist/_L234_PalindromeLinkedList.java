package edu.algos.li14_linkedlist;

import edu.algos.li30_model.ListNode;

public class _L234_PalindromeLinkedList {

	public static void main(String[] args) {
		
	}
	
    // Problem: https://leetcode.com/problems/palindrome-linked-list/
    // Idea: Split the linked list and reverse the second half and compare both the half elements one by one.
	public boolean isPalindrome(ListNode head1) {
        ListNode middle = split(head1);
        ListNode head2 = reverse(middle);
        
        ListNode curr1 = head1, curr2 = head2;
        while(curr1 != null && curr2 != null){
            if(curr1.val != curr2.val){   
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        return true;
    }
    
    // Incase odd elements in list, while splitting left half will have one extra element. Incase you want one extra element in right half use dummy node or start fast from head.next.
    // Similar, incase of even nodes. slow will point to second middle. To make it point it to first mid, use dummy node or start fast from head.next.
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
