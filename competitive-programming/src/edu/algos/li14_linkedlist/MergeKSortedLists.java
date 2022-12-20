package edu.algos.li14_linkedlist;

import edu.algos.li00_model.ListNode;

public class MergeKSortedLists {

	public static void main(String[] args) {
		MergeKSortedLists obj = new MergeKSortedLists();
		
		ListNode[] lists = new ListNode[3];
		SingleLinkedList l1 = new SingleLinkedList();
		l1.insertAtEnd(1);
		l1.insertAtEnd(4);
		l1.insertAtEnd(5);
		lists[0] = l1.head;
		
		SingleLinkedList l2 = new SingleLinkedList();
		l2.insertAtEnd(1);
		l2.insertAtEnd(3);
		l2.insertAtEnd(4);
		lists[1] = l2.head;
		
		SingleLinkedList l3 = new SingleLinkedList();
		l3.insertAtEnd(2);
		l3.insertAtEnd(6);
		lists[2] = l3.head;
		
		ListNode merged = obj.mergeKLists(lists);
		l1.head = merged;
		l1.print();

	}

	public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        
        while(lists.length > 1){
            int n = lists.length;
            ListNode[] merged = new ListNode[(int)Math.ceil(n/2.0)];
            for(int i=0; i<n; i=i+2){
                ListNode l1 = lists[i];
                if(i+1<n){
                    ListNode l2 = lists[i+1];
                    l1 = merge(l1, l2);
                }
                merged[i/2] = l1;
            }
            lists = merged;
        }
        
        return lists[0];
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {
		ListNode newHead = new ListNode(-1);
		ListNode temp = newHead;
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
		return newHead.next;
		
	}
}
