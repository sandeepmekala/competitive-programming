package edu.algos.li13_linkedlist;

import edu.algos.li00_model.ListNode;

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
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr){
                return true;
            }
        }
        return false;
    }
}
