package  com.algos.li14_linkedlist;

import java.util.Arrays;

import  com.algos.li30_model.ListNode;

public class _L725_SplitLinkedListInParts {

	public static void main(String[] args) {
		_L725_SplitLinkedListInParts obj = new _L725_SplitLinkedListInParts();

		_G01_SingleLinkedList list = new _G01_SingleLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.insertAtEnd(7);
		list.insertAtEnd(8);
		list.insertAtEnd(9);
		list.insertAtEnd(10);
		
		ListNode[] result = obj.splitListToParts(list.head, 3);
		System.out.println(Arrays.toString(result));
		
	}

	/*
	 * Problem: https://leetcode.com/problems/split-linked-list-in-parts/
	 * Companies: Amazon
     * Idea: Find part size. Traverse the list, once list become of length of part size, split it to make a new head and add new head to result.
     * Update part size as it can reduce if the remain list len become divisible by part size.
	 * */
	public ListNode[] splitListToParts(ListNode head, int k) {
        int len = getLen(head);
        
        ListNode[] result = new ListNode[k];
        int count=0, ind=0, psize = (int)Math.ceil(len/(k*1.0));;
        result[ind++] = head;

        ListNode curr = head;
        while(curr != null && curr.next != null){
            count++;
            if(count == psize){
                ListNode phead = curr.next;
                curr.next = null;
                curr = phead;
                count = 0;
                result[ind++] = phead;
                
                len = len - psize;
                k = k-1;
                psize = (int)Math.ceil(len/(k*1.0));
            }else{
                curr = curr.next;
            }
        }
        
        return result;
    }

    private int getLen(ListNode head) {
        int len=0;
        ListNode curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        return len;
    }
}
