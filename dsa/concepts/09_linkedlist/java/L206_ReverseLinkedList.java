
import com.algos.topics.models.ListNode;

public class L206_ReverseLinkedList {

	public static void main(String[] args) {
		L206_ReverseLinkedList obj = new L206_ReverseLinkedList();
		SingleLinkedList list = new SingleLinkedList();
		list.insertAfterEnd(1);
		list.insertAfterEnd(2);
		list.insertAfterEnd(3);
		list.print();

		list.head = obj.reverseList(list.head);
		// list.head = obj.reverseRec(list.head);
		System.out.println();
		list.print();

	}

	// Problem: https://leetcode.com/problems/reverse-linked-list/
	// Idea: Use prev, curr and next ptr's
	public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

	public ListNode reverseRec(ListNode node){
		if(node == null || node.next == null)
			return node;

		ListNode newHead = reverseRec(node.next);
		ListNode next = node.next;
		next.next = node;
		node.next = null;

		return newHead;
	}

}
