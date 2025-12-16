
public class FenwickTree {
    public static void main(String[] args) {
        FenwickTree obj = new FenwickTree(5);
        obj.update(1, 2);
        obj.update(2, 3);
        obj.update(3, 4);
        obj.update(4, 5);
        System.out.println(obj.query(3)); // Output: 9
        System.out.println(obj.rangeQuery(1, 3)); // Output: 9
        System.out.println(obj.find(8)); // Output: index 3
        System.out.println(obj.query(obj.find(8))); // Output: 9
    }

    private final int[] fen;
    int n;
    public FenwickTree(int n) {
        this.n = n;
        this.fen = new int[n + 1];
    }

    // Idea: Update the value at index i by adding to it in array.
    // Update all the values in the fenwick tree that are affected by this update.
    // Affected values are those whose index is a power of 2 and is a factor of i.
    // Those indices we can get by i + i & -i.
    // Time: O(log n)
    public void update(int i, int add) {
        while (i < fen.length) {
            fen[i] += add;
            i += i & -i;
        }
    }

    // Idea: Query the sum of values from 1 to i.
    // Traverse the fenwick tree from i to 1 and add the values to sum.
    // The indices we can get by i - i & -i.
    // Time: O(log n)
    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += fen[i];
            i -= i & -i;
        }
        return sum;
    }

    public int rangeQuery(int i, int j) {
        return query(j) - query(i - 1);
    }

    // Idea: Finds the index of lower bound of a sum k
    // This is called binary lifting.
    // Time: O(log n)
    public int find(int k) {
        int curr = 0, prevsum = 0;
        for (int i = (int)(Math.log(n) / Math.log(2)); i >= 0; i--) {
            if (fen[curr + (1 << i)] + prevsum < k) {
                curr += (1 << i);
                prevsum += fen[curr];
            }
        }
        return (curr + 1);
    }

}
