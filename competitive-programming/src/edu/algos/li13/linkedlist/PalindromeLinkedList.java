package edu.algos.li13.linkedlist;

import edu.algos.li00.model.ListNode;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		
	}
	
	public boolean isPalindrome(ListNode head) {
        ListNode middle = split(head);
        ListNode head2 = reverse(middle);
        while(head != null){
            if(head.val != head2.val){
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
    
    private ListNode split(ListNode head){
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy, fast = dummy.next;
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
