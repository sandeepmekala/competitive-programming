package com.algos.core.li09_linkedlist.revised;

import com.algos.core.models.ListNode;

public class L24_SwapNodesinPairs {
    public static void main(String[] args) {
        L24_SwapNodesinPairs obj = new L24_SwapNodesinPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head = obj.swapPairs(head);
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        return reverseKGroup(head, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1)
            return head;

        int length = getLength(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = null, curr = head;
        ListNode prevGroupLast = dummy, currGroupLast = null;
        while(length >= k){
            for(int i=0; i<k; i++) {
                if(i == 0) currGroupLast = curr;

                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            prevGroupLast.next = prev;
            prevGroupLast = currGroupLast;
            length -= k;
        }
        prevGroupLast.next = curr;

        return dummy.next;
    }

    private int getLength(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}
