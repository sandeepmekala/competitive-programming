
import com.algos.topics.models.ListNode;

public class L83_RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		L83_RemoveDuplicatesFromSortedList obj = new L83_RemoveDuplicatesFromSortedList();

		SingleLinkedList list = new SingleLinkedList();
		list.insertAfterEnd(2);
		list.insertAfterEnd(2);
		list.insertAfterEnd(3);
		list.insertAfterEnd(3);
		list.insertAfterEnd(4);

		list.head = obj.deleteDuplicates(list.head);
		list.print();
	}

	// Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
	// Idea: Compare curr and curr.next vals, if equal, change curr.next to curr.next.next.
	public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }

        return head;
    }

}
