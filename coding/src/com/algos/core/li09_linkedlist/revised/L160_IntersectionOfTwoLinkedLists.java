package  com.algos.core.li09_linkedlist.revised;

import  com.algos.core.li30_model.ListNode;

public class L160_IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        
    }

    // Problem: https://leetcode.com/problems/intersection-of-two-linked-lists/
    // Idea: 
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr1 = headA, curr2 = headB;
        while(curr1 != curr2){
            if(curr1 != null) {
                curr1 = curr1.next;
            } else{
                curr1 = headB;
            }
            
            if(curr2 != null){
                curr2 = curr2.next;
            } else{
                curr2 = headA;
            }
        }
        return curr1;
    }
}
