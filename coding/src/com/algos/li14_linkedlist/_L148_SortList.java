package  com.algos.li14_linkedlist;

import  com.algos.li30_model.ListNode;

public class _L148_SortList {

	static _G01_SingleLinkedList sll = new _G01_SingleLinkedList();
	public static void main(String[] args) {
		_L148_SortList obj = new _L148_SortList();

		sll.insertAtEnd(7);
		sll.insertAtEnd(10);
		sll.insertAtEnd(5);
		sll.insertAtEnd(20);
		sll.insertAtEnd(3);
		sll.insertAtEnd(2);
		
		ListNode newHead = obj.sortList(sll.head);
		sll.head = newHead;
		sll.print();
		
	}

	// Problem: https://leetcode.com/problems/sort-list/
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
