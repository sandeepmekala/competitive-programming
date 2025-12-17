
import com.algos.topics.models.ListNode;

public class L2_AddTwoNumbers {

	public static void main(String[] args) {
		L2_AddTwoNumbers obj = new L2_AddTwoNumbers();
		SingleLinkedList list1 = new SingleLinkedList();
		list1.insertAfterEnd(2);
		list1.insertAfterEnd(4);
		list1.insertAfterEnd(3);

		SingleLinkedList list2 = new SingleLinkedList();
		list2.insertAfterEnd(5);
		list2.insertAfterEnd(6);
		list2.insertAfterEnd(4);

		SingleLinkedList list = new SingleLinkedList();
		list.head = obj.addTwoNumbers(list1.head, list2.head);
		list.print();
	}

	// Problem: https://leetcode.com/problems/add-two-numbers/
	// Idea: Use similar number addition technique.
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode start = new ListNode();
		ListNode curr = start;
		int carry = 0;
		while (l1 != null || l2 != null || carry > 0) {
			int val1 = (l1 != null)? l1.val : 0;
			int val2 = (l2 != null)? l2.val : 0;

			int sum = val1 + val2 + carry;
			ListNode newNode = new ListNode();
			newNode.val = sum % 10;
			carry = sum / 10;
			curr.next = newNode;

			curr = curr.next;
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}

		return start.next;
	}
}
