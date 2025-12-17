
import java.util.HashMap;
import java.util.Map;

public class L146_LRUCache {
	public static void main(String[] args) {
		L146_LRUCache obj = new L146_LRUCache(2);
		obj.put(1, 1);
		obj.put(2, 2);
		System.out.println(obj.get(1));
		obj.put(3, 3);
		System.out.println(obj.get(2));
		obj.put(4, 4);
		System.out.println(obj.get(1));
		System.out.println(obj.get(3));
		System.out.println(obj.get(4));
	}

	Node head = new Node(0, 0), tail = new Node(0, 0);
	Map<Integer, Node> cache = new HashMap<>();
	int capacity;

	public L146_LRUCache(int capacity) {
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			Node node = cache.get(key);
			remove(node);				// removes from map and dll
			insert(node);				// inserts to map and dll
			return node.value;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			remove(cache.get(key));
		}
		if (cache.size() == capacity) {
			remove(tail.prev);
		}
		insert(new Node(key, value));
	}

	private void remove(Node node) {
		cache.remove(node.key);
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private void insert(Node node) {
		cache.put(node.key, node);
		node.next = head.next;
		node.next.prev = node;
		head.next = node;
		node.prev = head;
	}

	class Node {
		Node prev, next;
		int key, value;

		Node(int _key, int _value) {
			key = _key;
			value = _value;
		}
	}
}
