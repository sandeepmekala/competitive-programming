
import com.algos.topics.models.ListNode;

public class L142_LinkedListCycleII {

	public static void main(String[] args) {
		L142_LinkedListCycleII obj = new L142_LinkedListCycleII();
		SingleLinkedList list = new SingleLinkedList();
		list.insertBeforeHead(3);
		list.insertAfterEnd(2);
		list.insertAfterEnd(0);
		list.insertAfterEnd(-4);
		list.head.next.next.next.next = list.head.next;
		System.out.println(obj.detectCycle(list.head));
	}

	/*
        Problem: https://leetcode.com/problems/linked-list-cycle-ii
        Idea:
	 	    Step 1: Detect cycle using FCD.
	 	    Step 2: Place one pointer at head of LL | Another pointer should be at the point where fast and slow meet.
		    Step 3: Move 1st pointer and 2nd pointer by one step each.
		    Step 4: Both will meet again at entry point of cycle.
	 */
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}
