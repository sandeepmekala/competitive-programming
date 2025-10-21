package  com.algos.topics.li09_linkedlist.revised;

import com.algos.topics.models.ListNode;

public class L203_RemoveLinkedListElements {

	public static void main(String[] args) {
		L203_RemoveLinkedListElements obj = new L203_RemoveLinkedListElements();

		SingleLinkedList list = new SingleLinkedList();
		list.insertAfterEnd(2);
		list.insertAfterEnd(4);
		list.insertAfterEnd(3);
		list.insertAfterEnd(2);

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
