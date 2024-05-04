package  com.algos.li09_linkedlist.revised;

import  com.algos.li30_model.ListNode;

public class L234_PalindromeLinkedList {

	public static void main(String[] args) {
        L234_PalindromeLinkedList obj = new L234_PalindromeLinkedList();

        SingleLinkedList list = new SingleLinkedList();
        list.insertAfterEnd(1);
        list.insertAfterEnd(2);
        list.insertAfterEnd(3);
        list.insertAfterEnd(2);
        list.insertAfterEnd(1);

        System.out.println(obj.isPalindrome(list.head));
	}
	
    // Problem: https://leetcode.com/problems/palindrome-linked-list/
    // Idea: Split the linked list and reverse the second half and compare both the half elements one by one.
	public boolean isPalindrome(ListNode head1) {
        ListNode middle = split(head1);
        ListNode head2 = reverse(middle);
        
        ListNode curr1 = head1, curr2 = head2;
        while(curr1 != null && curr2 != null){
            if(curr1.val != curr2.val)
                return false;
            
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        return true;
    }
    
    // Incase even len list, we need to stop slow ptr at first middle node
    // In that case, fast ptr will stop at second last node. Hence fast.next.next != null.
    // Incase odd len list, fast ptr will stop at last node. Hence fast.next != null.
    private ListNode split(ListNode head){
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
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
