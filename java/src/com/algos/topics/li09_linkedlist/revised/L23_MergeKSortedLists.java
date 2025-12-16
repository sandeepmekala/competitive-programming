package com.algos.topics.li09_linkedlist.revised;

import java.util.PriorityQueue;
import java.util.Queue;

import com.algos.topics.models.ListNode;

public class L23_MergeKSortedLists {

	public static void main(String[] args) {
		L23_MergeKSortedLists obj = new L23_MergeKSortedLists();

		ListNode[] lists = new ListNode[3];
		SingleLinkedList l1 = new SingleLinkedList();
		l1.insertAfterEnd(1);
		l1.insertAfterEnd(4);
		l1.insertAfterEnd(5);
		lists[0] = l1.head;

		SingleLinkedList l2 = new SingleLinkedList();
		l2.insertAfterEnd(1);
		l2.insertAfterEnd(3);
		l2.insertAfterEnd(4);
		lists[1] = l2.head;

		SingleLinkedList l3 = new SingleLinkedList();
		l3.insertAfterEnd(2);
		l3.insertAfterEnd(6);
		lists[2] = l3.head;

		ListNode merged = obj.mergeKLists(lists);
		l1.head = merged;
		l1.print();

	}

	// Problem: https://leetcode.com/problems/merge-k-sorted-lists/
	// Idea: Push all the nodes to min heap. Pop the min node and add it to the result and push the next of it.
	// Time: O(klogk + knlogk), Space: O(1)
	public ListNode mergeKLists(ListNode[] lists) {
		Queue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
		for (ListNode node : lists)
			if (node != null)
				pq.add(node);

		ListNode dummy = new ListNode(-1);
		ListNode curr = dummy;
		while (!pq.isEmpty()) {
			ListNode node = pq.poll();
			curr.next = node;
			curr = curr.next;
			if (node.next != null)
				pq.add(node.next);
		}
		return dummy.next;
	}
}
