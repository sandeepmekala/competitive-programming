package  com.algos.li16_design.revised;

import java.util.HashMap;
import java.util.Map;

public class L460_LFUCache {
    final int capacity;
    int curSize;
    int minFreq;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> freqMap;

    public L460_LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFreq = 0;

        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        DLLNode curNode = cache.get(key);
        if (curNode == null) {
            return -1;
        }
        updateNode(curNode);
        return curNode.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLLNode curNode = cache.get(key);
            curNode.val = value;
            updateNode(curNode);
        }
        else {
            curSize++;
            if (curSize > capacity) {
                // get minimum frequency list
                DoubleLinkedList minFreqList = freqMap.get(minFreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            // reset min frequency to 1 because of adding new node
            minFreq = 1;
            DLLNode newNode = new DLLNode(key, value);

            // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
            DoubleLinkedList curList = freqMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            freqMap.put(1, curList);
            cache.put(key, newNode);
        }
    }

    public void updateNode(DLLNode curNode) {
        int curFreq = curNode.frequency;
        DoubleLinkedList curList = freqMap.get(curFreq);
        curList.removeNode(curNode);

        // if current list the the last list which has lowest frequency and current node is the only node in that list
        // we need to remove the entire list and then increase min frequency value by 1
        if (curFreq == minFreq && curList.listSize == 0) {
            minFreq++;
        }

        curNode.frequency++;
        // add current node to another list has current frequency + 1,
        // if we do not have the list with this frequency, initialize it
        DoubleLinkedList newList = freqMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode);
        freqMap.put(curNode.frequency, newList);
    }
}

class DLLNode {
    int key;
    int val;
    int frequency;
    DLLNode prev;
    DLLNode next;

    public DLLNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.frequency = 1;
    }
}

class DoubleLinkedList {
    int listSize;
    DLLNode head;
    DLLNode tail;
    public DoubleLinkedList() {
        this.listSize = 0;
        this.head = new DLLNode(0, 0);
        this.tail = new DLLNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(DLLNode curNode) {
        DLLNode nextNode = head.next;
        curNode.next = nextNode;
        curNode.prev = head;
        head.next = curNode;
        nextNode.prev = curNode;
        listSize++;
    }

    public void removeNode(DLLNode curNode) {
        DLLNode prevNode = curNode.prev;
        DLLNode nextNode = curNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        listSize--;
    }
}
