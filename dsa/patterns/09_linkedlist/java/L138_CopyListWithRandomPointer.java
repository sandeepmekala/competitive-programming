import java.util.HashMap;

import com.algos.topics.models.Node;

public class L138_CopyListWithRandomPointer {

	public static void main(String[] args) {

		SingleLinkedList list = new SingleLinkedList();
		list.insertAfterEnd(1);
		list.insertAfterEnd(2);
		list.insertAfterEnd(3);
		list.insertAfterEnd(4);
		list.insertAfterEnd(5);

	}

    // Problem: https://leetcode.com/problems/copy-list-with-random-pointer/
    // Idea: Use map to store the mapping between node and its copy
    // In first pass create copies of each node and and store
    // In second pass, get the copy of each node and adjust its next and ran pointers.
    // You can solve it inplace by following 3 steps below:
    //      You need to insert copy nodes next to their original nodes.
    //      Then create random ptrs.
    //      Then change next ptrs.
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;
        while(curr != null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}
