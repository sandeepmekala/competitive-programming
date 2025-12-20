import com.algos.topics.models.ListNode;

public class L369_PlusOneLinkedList {

        public static void main(String[] args) {
            L369_PlusOneLinkedList obj = new L369_PlusOneLinkedList();

            SingleLinkedList list = new SingleLinkedList();
            list.insertAfterEnd(1);
            list.insertAfterEnd(2);
            list.insertAfterEnd(3);
            list.insertAfterEnd(4);
            list.insertAfterEnd(5);

            list.head = obj.plusOne(list.head);
            list.print();

            list.hashCode();
        }

        // Problem: https://leetcode.com/problems/plus-one-linked-list/
        // Idea: Use two pointers to keep track of odd
        public ListNode plusOne(ListNode head) {
            if (head == null) return new ListNode(1);

            // Find the rightmost digit that is not 9
            ListNode notNine = null;
            ListNode curr = head;

            while (curr != null) {
                if (curr.val != 9) {
                    notNine = curr;
                }
                curr = curr.next;
            }

            // If all digits are 9, we need to add a new node at the beginning
            if (notNine == null) {
                ListNode newHead = new ListNode(1);
                newHead.next = head;
                curr = head;
                while (curr != null) {
                    curr.val = 0;
                    curr = curr.next;
                }
                return newHead;
            }

            // Increment the rightmost non-9 digit
            notNine.val++;

            // Set all digits after notNine to 0
            curr = notNine.next;
            while (curr != null) {
                curr.val = 0;
                curr = curr.next;
            }

            return head;
        }
}
