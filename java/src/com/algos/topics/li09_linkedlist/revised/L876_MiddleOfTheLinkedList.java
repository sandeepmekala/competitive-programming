package  com.algos.topics.li09_linkedlist.revised;

import com.algos.topics.models.ListNode;

public class L876_MiddleOfTheLinkedList {

	public static void main(String[] args) {
		L876_MiddleOfTheLinkedList obj = new L876_MiddleOfTheLinkedList();

		SingleLinkedList list = new SingleLinkedList();
		list.insertAfterEnd(1);
		list.insertAfterEnd(2);
		list.insertAfterEnd(3);
		list.insertAfterEnd(4);
		list.insertAfterEnd(5);

		System.out.println(obj.middleNode(list.head));
	}

	// Problem: https://leetcode.com/problems/middle-of-the-linked-list/
	// Idea: Use fast and slow pointers
	public ListNode middleNode(ListNode head) {
        ListNode slow = head,fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
