import com.algos.topics.models.ListNode;

public class L21_MergeTwoSortedLists {
    public static void main(String[] args) {
		L21_MergeTwoSortedLists obj = new L21_MergeTwoSortedLists();
		SingleLinkedList list1 = new SingleLinkedList();
		list1.insertAfterEnd(1);
		list1.insertAfterEnd(2);
		list1.insertAfterEnd(4);

		SingleLinkedList list2 = new SingleLinkedList();
		list2.insertAfterEnd(1);
		list2.insertAfterEnd(3);
		list2.insertAfterEnd(4);

		ListNode head = obj.mergeTwoLists(list1.head, list2.head);
		list1.head = head;
		list1.print();
    }

    // Problem: https://leetcode.com/problems/merge-two-sorted-lists/
    // Idea: Similar technique as mergin arrays.
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);

		ListNode curr = dummy;
		ListNode curr1 = head1;
		ListNode curr2 = head2;
		while(curr1 != null && curr2 != null) {
			if(curr1.val < curr2.val) {
				curr.next = curr1;
				curr1 = curr1.next;
			}else {
				curr.next = curr2;
				curr2 = curr2.next;
			}
			curr = curr.next;
		}
		if(curr1 != null)
			curr.next = curr1;
		if(curr2 != null)
			curr.next = curr2;

		return dummy.next;
    }
}
