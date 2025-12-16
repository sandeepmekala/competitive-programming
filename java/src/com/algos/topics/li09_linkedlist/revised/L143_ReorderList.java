package  com.algos.topics.li09_linkedlist.revised;

import com.algos.topics.models.ListNode;

public class L143_ReorderList {

	public static void main(String[] args) {
		L143_ReorderList obj = new L143_ReorderList();
		SingleLinkedList list = new SingleLinkedList();
		list.insertAfterEnd(1);
		list.insertAfterEnd(2);
		list.insertAfterEnd(3);
		list.insertAfterEnd(4);

		list.print();
		obj.reorderList(list.head);
		System.out.println();
		list.print();
	}

	// Problem: https://leetcode.com/problems/reorder-list/
	// Idea: Split the list, reverse the second list and merge.
	public void reorderList(ListNode head1) {
        if(head1.next == null || head1.next.next == null)
            return;

        ListNode head2 = split(head1);
        head2 = reverse(head2);

        ListNode curr1 = head1, curr2 = head2;
        while(curr1 != null && curr2 != null){
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;
            curr1.next = curr2;
            curr2.next = next1;

            curr1 = next1;
            curr2 = next2;
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
        return prev;
    }

    private ListNode split(ListNode head1) {
        ListNode slow = head1;
        ListNode fast = head1.next;         // delay slow by one step
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        return head2;
    }

}
