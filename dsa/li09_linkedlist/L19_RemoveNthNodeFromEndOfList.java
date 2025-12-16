package li09_linkedlist;

import com.algos.topics.models.ListNode;

public class L19_RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		L19_RemoveNthNodeFromEndOfList obj = new L19_RemoveNthNodeFromEndOfList();
		SingleLinkedList list = new SingleLinkedList();
		list.insertAfterEnd(1);
		list.insertAfterEnd(2);
		list.insertAfterEnd(3);
		list.insertAfterEnd(4);

		list.head = obj.removeNthFromEnd(list.head, 4);     // 2 3 4
		list.print();
	}

    // Problem: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    // Idea: First move right ptr to n nodes. Then move both left and right ptr till right.right is null.
    // Now the left node which was pointing head node, points to n+1th node fron last. Remove nth node.
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head, right = head;
        for (int cnt = 0; cnt < n; cnt++)
            right = right.next;

        if(right == null)       // Remove head case
            return head.next;

        right = right.next;     // As we want left ptr to be delayed by one node
        while(right != null){
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return head;
    }

}
