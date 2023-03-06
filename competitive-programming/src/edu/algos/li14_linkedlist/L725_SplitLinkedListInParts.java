package edu.algos.li14_linkedlist;

import java.util.Arrays;

import edu.algos.li00_model.ListNode;

public class L725_SplitLinkedListInParts {

	public static void main(String[] args) {
		L725_SplitLinkedListInParts obj = new L725_SplitLinkedListInParts();

		_A01_SingleLinkedList list = new _A01_SingleLinkedList();
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
     * Idea: Find part size. Traverse the list, once list become of length of part size, split is make a new head and add new head to result.
     * Update part size as it can reduce if the remain list len become divisible by part size.
	 * */
	public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        
        int count = 0, ind=0, partSize = (int)Math.ceil(len/(k*1.0));;
        ListNode[] result = new ListNode[k];
        result[ind++] = head;
        curr = head;
        while(curr != null && curr.next != null){
            count++;
            if(count == partSize){
                ListNode partHead = curr.next;
                curr.next = null;
                curr = partHead;
                count = 0;
                result[ind++] = partHead;
                
                len = len - partSize;
                k = k-1;
                partSize = (int)Math.ceil(len/(k*1.0));
            }else{
                curr = curr.next;
            }
        }
        
        return result;
    }
}
