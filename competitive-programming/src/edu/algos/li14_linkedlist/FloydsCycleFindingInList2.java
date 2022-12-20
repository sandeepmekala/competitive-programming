package edu.algos.li14_linkedlist;

import edu.algos.li00_model.ListNode;

public class FloydsCycleFindingInList2 {

	public static void main(String[] args) {
		FloydsCycleFindingInList2 obj = new FloydsCycleFindingInList2();
		SingleLinkedList list = new SingleLinkedList();
		list.insertAtBegining(3);
		list.insertAtEnd(2);
		list.insertAtEnd(0);
		list.insertAtEnd(-4);
		list.head.next.next.next.next = list.head.next;
		System.out.println(obj.detectCycle(list.head));
	}

	/*
	 	STEP 1: Detect cycle using FCD
	 	STEP 2: Place one pointer at head of LL | Another pointer should be at the point where fast and slow meet
		STEP 3: Move 1st pointer and 2nd pointer by one step each 
		STEP 4: Both will meet again at entry point of cycle 
	
	 */
    public ListNode detectCycle(ListNode head) {
        
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr){
                slowPtr = head;
                while(slowPtr != fastPtr){
                    slowPtr = slowPtr.next;
                    fastPtr = fastPtr.next;
                }
                return slowPtr;
            }
        }
        return null;
    }
}
