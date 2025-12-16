package li09_linkedlist;

import java.util.Arrays;

import com.algos.topics.models.ListNode;

public class L725_SplitLinkedListInParts {

	public static void main(String[] args) {
		L725_SplitLinkedListInParts obj = new L725_SplitLinkedListInParts();

		SingleLinkedList list = new SingleLinkedList();
		list.insertAfterEnd(1);
		list.insertAfterEnd(2);
		list.insertAfterEnd(3);
		list.insertAfterEnd(4);
		list.insertAfterEnd(5);
		list.insertAfterEnd(6);
		list.insertAfterEnd(7);
		list.insertAfterEnd(8);
		list.insertAfterEnd(9);
		list.insertAfterEnd(10);

		ListNode[] result = obj.splitListToParts(list.head, 3);
		System.out.println(Arrays.toString(result));

	}

	/*
	 * Problem: https://leetcode.com/problems/split-linked-list-in-parts/
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
