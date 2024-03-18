package  com.algos.li09_linkedlist.revised;

import com.algos.li09_linkedlist.SingleLinkedList;
import  com.algos.li30_model.ListNode;

public class L203_RemoveLinkedListElements {

	public static void main(String[] args) {
		L203_RemoveLinkedListElements obj = new L203_RemoveLinkedListElements();
		
		SingleLinkedList list = new SingleLinkedList();
		list.insertAtEnd(2);
		list.insertAtEnd(4);
		list.insertAtEnd(3);
		list.insertAtEnd(2);
		
		list.head = obj.removeElements(list.head, 2);
		list.print();		
	}

	/*
	 * Problem: https://leetcode.com/problems/remove-linked-list-elements/
	 * Idea: We might have to remove head also. To simplify that add start node.
	 * */
	public ListNode removeElements(ListNode head, int val) {
        ListNode start = new ListNode();
        start.next = head ; 

        ListNode curr = start;
        while(curr != null && curr.next != null){
            if(curr.next.val == val)
                curr.next = curr.next.next;
            else curr = curr.next;
        }
        
        return start.next;
    }
}
