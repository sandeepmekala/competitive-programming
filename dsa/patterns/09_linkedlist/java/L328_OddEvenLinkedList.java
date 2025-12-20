import com.algos.topics.models.ListNode;

public class L328_OddEvenLinkedList {

    public static void main(String[] args) {
        L328_OddEvenLinkedList obj = new L328_OddEvenLinkedList();

        SingleLinkedList list = new SingleLinkedList();
		list.insertAfterEnd(1);
		list.insertAfterEnd(2);
		list.insertAfterEnd(3);
		list.insertAfterEnd(4);
		list.insertAfterEnd(5);

        list.head = obj.oddEvenList(list.head);
        list.print();
    }

    // Problem: https://leetcode.com/problems/odd-even-linked-list/
    // Idea: Use two pointers to keep track of odd and even nodes.
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode odd = head, even = head.next, evenHead = even;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }

}
