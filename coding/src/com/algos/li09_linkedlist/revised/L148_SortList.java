package  com.algos.li09_linkedlist.revised;

import  com.algos.li30_model.ListNode;

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
		
		ListNode newHead = obj.sortList(sll.head);
		sll.head = newHead;
		sll.print();
		
	}

	// Problem: https://leetcode.com/problems/sort-list/
	// Idea: Use merge sort, ll split techniques
	public ListNode sortList(ListNode node){
		if(node == null || node.next == null) 
			return node;

		ListNode head1 = node;
		ListNode head2 = split(node);
		
		ListNode nhead1 = sortList(head1);
		ListNode nhead2 = sortList(head2);
		ListNode nhead = merge(nhead1, nhead2);
		return nhead;
	}

	private ListNode merge(ListNode head1, ListNode head2) {
		ListNode start = new ListNode(-1);
		ListNode curr = start;
		while(head1 != null && head2 != null) {
			if(head1.val < head2.val) {
				curr.next = head1;
				head1 = head1.next;
			}else {
				curr.next = head2;
				head2 = head2.next;
			}
			curr = curr.next;
		}
		while(head1 != null) {
			curr.next = head1;
			curr = curr.next;
			head1 = head1.next;
		}
		while(head2 != null) {
			curr.next = head2;
			curr = curr.next;
			head2 = head2.next;
		}

		return start.next;
	}
	
	private ListNode split(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode head2 = slow.next;
		slow.next = null;
		return head2;
	}
}
