package  com.algos.li14_linkedlist;

import  com.algos.li30_model.ListNode;

public class G03_FlatteningOfALinkedList {
    public static void main(String[] args) {

    }

    public ListNode flatten(ListNode root) {
        if (root == null || root.next == null)
            return root;

        // recur for list on right
        root.next = flatten(root.next);

        // now merge
        root = mergeTwoLists(root, root.next);

        // return the root
        // it will be in turn merged with its left
        return root;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode curr = start;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                start.bottom = l1;
                start = start.bottom;
                l1 = l1.bottom;
            } else {
                start.bottom = l2;
                start = start.bottom;
                l2 = l2.bottom;
            }
        }

        if (l1 != null)
            start.bottom = l1;
        else
            start.bottom = l2;
        return curr.bottom;

    }
}
