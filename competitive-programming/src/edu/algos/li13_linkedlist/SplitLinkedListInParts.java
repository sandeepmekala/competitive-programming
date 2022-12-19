package edu.algos.li13_linkedlist;

import java.util.Arrays;

import edu.algos.li00_model.ListNode;

public class SplitLinkedListInParts {

	public static void main(String[] args) {
		SplitLinkedListInParts obj = new SplitLinkedListInParts();

		SingleLinkedList list = new SingleLinkedList();
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
	 * */
	public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0, ind=0, len = 0;
        ListNode curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        
        int partSize = len/k;
        if(len%k != 0) partSize = partSize+1;
        
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
                
                partSize = len/k;
                if(len%k != 0) partSize = partSize+1;
            }else{
                curr = curr.next;
            }
        }
        
        return result;
    }
}
