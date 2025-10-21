package  com.algos.core.li09_linkedlist.revised;

import com.algos.core.models.ListNode;

public class L160_IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {

    }

    // Problem: https://leetcode.com/problems/intersection-of-two-linked-lists/
    // Idea: Exchange curr1 and curr2 when they reach end of their respective lists.
    // They will meet at the intersection node.
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        ListNode curr1 = head1, curr2 = head2;
        while(curr1 != curr2){
            if(curr1 != null) {
                curr1 = curr1.next;
            } else{
                curr1 = head2;
            }

            if(curr2 != null){
                curr2 = curr2.next;
            } else{
                curr2 = head1;
            }
        }
        return curr1;
    }
}
