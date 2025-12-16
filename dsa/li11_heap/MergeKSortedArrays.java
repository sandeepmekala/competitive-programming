package li11_heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedArrays {

    public static void main(String[] args) {
        int[][] arrays = {
            {1, 4, 5},
            {1, 3, 4},
            {2, 6}
        };

        System.out.println(Arrays.toString(mergeKSortedArrays(arrays)));
    }

    public static int[] mergeKSortedArrays(int[][] arrays) {
        Queue<Tuple> pq = new PriorityQueue<>((t1, t2) -> t1.value - t2.value);
        int totalLength = 0;

        // Initialize the heap with the first element of each array
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                pq.offer(new Tuple(arrays[i][0], i, 0));    // value, arrayIndex, elementIndex
                totalLength += arrays[i].length;
            }
        }

        int[] ans = new int[totalLength];
        int index = 0;

        while (!pq.isEmpty()) {
            Tuple curr = pq.remove();
            ans[index++] = curr.value;

            // If there is a next element in the same array, add it to the heap
            if (curr.elmIndex + 1 < arrays[curr.arrIndex].length) {
                pq.add(new Tuple(arrays[curr.arrIndex][curr.elmIndex + 1],
                        curr.arrIndex, curr.elmIndex + 1));
            }
        }

        return ans;
    }
}

class Tuple{
    int value;
    int arrIndex;
    int elmIndex;

    public Tuple(int value, int arrayIndex, int elementIndex) {
        this.value = value;
        this.arrIndex = arrayIndex;
        this.elmIndex = elementIndex;
    }
}
