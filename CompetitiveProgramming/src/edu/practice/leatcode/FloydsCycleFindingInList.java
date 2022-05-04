package edu.practice.leatcode;

import edu.algos.linkedlist.model.ListNode;
import edu.algos.linkedlists.SingleLinkedList;

public class FloydsCycleFindingInList {

	public static void main(String[] args) {
		FloydsCycleFindingInList obj = new FloydsCycleFindingInList();
		SingleLinkedList list = new SingleLinkedList();
		list.insertAtBegining(3);
		list.insertAtEnd(2);
		list.insertAtEnd(0);
		list.insertAtEnd(-4);
		list.head.next.next.next.next = list.head.next;
		System.out.println(obj.hasCycle(list.head));
	}
	
	public boolean hasCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(slowPtr != null && fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr){
                return true;
            }
        }
        return false;
    }
}
