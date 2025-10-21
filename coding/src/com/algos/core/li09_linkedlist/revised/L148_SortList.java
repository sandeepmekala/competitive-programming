package  com.algos.core.li09_linkedlist.revised;

import com.algos.core.models.ListNode;

public class L148_SortList {

	static SingleLinkedList sll = new SingleLinkedList();
	public static void main(String[] args) {
		L148_SortList obj = new L148_SortList();

		sll.insertAfterEnd(7);
		sll.insertAfterEnd(10);
		sll.insertAfterEnd(5);
		sll.insertAfterEnd(20);
		sll.insertAfterEnd(3);
		sll.insertAfterEnd(2);

		ListNode newHead = obj.sortList(sll.head);		// 2 3 5 7 10 20
		sll.head = newHead;
		sll.print();

	}

	// Problem: https://leetcode.com/problems/sort-list/
	// Idea: Use merge sort, ll split techniques
	// Time: O((n+n/2)logn), Space: O(1)
	public ListNode sortList(ListNode node){
		if(node == null || node.next == null)
			return node;

		ListNode head1 = node;
		ListNode head2 = split(node);

		head1 = sortList(head1);
		head2 = sortList(head2);
		return merge(head1, head2);
	}

	private ListNode merge(ListNode head1, ListNode head2) {
		ListNode start = new ListNode(-1);
		ListNode curr = start;
		ListNode curr1 = head1;
		ListNode curr2 = head2;
		while(curr1 != null && curr2 != null) {
			if(curr1.val <= curr2.val) {
				curr.next = curr1;
				curr1 = curr1.next;
			}else {
				curr.next = curr2;
				curr2 = curr2.next;
			}
			curr = curr.next;
		}
		if(curr1 != null)
			curr.next = curr1;
		if(curr2 != null)
			curr.next = curr2;

		return start.next;
	}

	private ListNode split(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next.next;		// Skip one step for slow to stop it at first mid in case of even nodes
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode head2 = slow.next;
		slow.next = null;
		return head2;
	}
}
