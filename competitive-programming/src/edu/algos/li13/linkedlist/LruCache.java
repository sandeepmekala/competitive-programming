package edu.algos.li13.linkedlist;

import java.util.HashMap;

import edu.algos.li00.model.ListNode;

public class LruCache {

	public static void main(String[] args) {
		LruCache obj = new LruCache(2);
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
	
	ListNode lru, mru;
    int capacity;
    HashMap<Integer, ListNode> cache = new HashMap<Integer, ListNode>();
    public LruCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {				// doesn't contain key
        	return -1;
        }else {	
        	ListNode curr = cache.get(key);
        	remove(curr.key, curr.val);				// remove to properly adjust pointers
        	put(curr.key, curr.val);				// reinsert to update mru possibly lru also
        	return curr.val;
        }
    }
    
    public void put(int key, int value) {
        if(cache.size() == 0){						// empty cache
        	ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.val = value;
        	cache.put(key, newNode);
            lru = newNode;
            mru = newNode;
        }else if(cache.containsKey(key)){			// already contains key
        	ListNode old = cache.get(key);
        	remove(old.key, old.val);
        	put(key, value);
        }else{										// doesn't contain key
        	if(cache.size() < capacity) {			// not overflowing
        		ListNode newNode = new ListNode();
                newNode.key = key;
                newNode.val = value;
                cache.put(key, newNode);

                mru.next = newNode;
                newNode.prev = mru;
                mru = newNode;
        	}else {									// overflowing
        		remove(lru.key, lru.val);
        		put(key, value);
        	}        	
        }
    }

	private void remove(int key, int value) {
		ListNode old = cache.remove(key);
		if(cache.size() == 0) {
			lru = null;
			mru = null;
		}else if(cache.size() == 1){		// removing lru/mru
			if(old == lru) {
				lru = lru.next;
                lru.prev = null;
                mru.prev = null;
			}else {
				mru = mru.prev;
				mru.next = null;
				lru.next = null;
			}
		}else {
			if(old == lru) {				// removing lru
				lru = lru.next;
				lru.prev = null;
			}else if(old == mru) {			// removing mru
				mru = mru.prev;
				mru.next = null;
			}else {							// removing middle element
				old.prev.next = old.next;
				old.next.prev = old.prev;
			}
		}
	}
}
