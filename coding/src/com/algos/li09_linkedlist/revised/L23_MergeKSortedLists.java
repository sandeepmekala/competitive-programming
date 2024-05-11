package  com.algos.li09_linkedlist.revised;

import java.util.List;
import java.util.PriorityQueue;

import  com.algos.li30_model.ListNode;

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
	// Idea: Use merge of 2 list technique. Divide the lists in n/2 groups and merge them.
	// Swap lists with merged list for next iteration.
	// Continue the same until only one list remains
	// Time: O(klogk + knlogk), Space: O(1)
	public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.val - p2.val);
        for(ListNode node: lists)
            if(node != null) 
				pq.add(new Pair(node.val, node));
		
		ListNode dummy = new ListNode(-1);
		ListNode curr = dummy;
		while(!pq.isEmpty()){
			Pair top = pq.poll();
			curr.next = top.node;
			curr = curr.next;
			if(top.node.next != null)
				pq.add(new Pair(top.node.next.val, top.node.next));
			
		}
        return dummy.next;
    }
}

class Pair{
	int val;
	ListNode node;
	Pair(int num, ListNode node){
		this.val = num;
		this.node = node;
	}
}
