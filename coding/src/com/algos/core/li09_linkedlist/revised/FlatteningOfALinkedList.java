package  com.algos.core.li09_linkedlist.revised;

import com.algos.core.models.ListNode;

public class FlatteningOfALinkedList {
    public static void main(String[] args) {
        FlatteningOfALinkedList obj = new FlatteningOfALinkedList();
        ListNode head = new ListNode(5);
        head.bottom = new ListNode(7);
        head.bottom.bottom = new ListNode(8);
        head.bottom.bottom.bottom = new ListNode(30);

        head.next = new ListNode(10);
        head.next.bottom = new ListNode(20);

        head.next.next = new ListNode(19);
        head.next.next.bottom = new ListNode(22);
        head.next.next.bottom.bottom = new ListNode(50);

        head.next.next.next = new ListNode(28);
        head.next.next.next.bottom = new ListNode(35);
        head.next.next.next.bottom.bottom = new ListNode(40);

        head = obj.flatten(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.bottom;
        }

    }

    public ListNode flatten(ListNode root) {
        if (root == null || root.next == null)
            return root;

        ListNode mergedList = flatten(root.next);
        return mergeTwoLists(root, mergedList);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.bottom = l1;
                curr = curr.bottom;
                l1 = l1.bottom;
            } else {
                curr.bottom = l2;
                curr = curr.bottom;
                l2 = l2.bottom;
            }
        }

        if (l1 != null)
            curr.bottom = l1;
        else
            curr.bottom = l2;
        return dummy.bottom;

    }
}
