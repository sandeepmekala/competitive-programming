package algos.dp;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumHeightOfBoxStacking {

	public static void main(String[] args) {
		Box[] boxes = new Box[] {
				new Box(1,2,4),
				new Box(3,2,5),
		};
		System.out.println(maxHeight(boxes, boxes.length));
	}

	//time = O(n)
	//space = O(n)
	private static int maxHeight(Box[] boxes, int m) {
		int maxHeight = 0;
		int n = 3*boxes.length;
		Box[] comb = new Box[n];
		int k=0;
		for(int i = 0; i<boxes.length; i++) {
			Box[] temp = getCombinations(boxes[i]);
			for(int j=0; j<temp.length; j++) {
				comb[k++] = temp[j];
			}
		}
		Arrays.sort(comb, new Comparator<Box>() {
			public int compare(Box b1, Box b2) {
				return b2.l*b2.w - b1.l*b1.w; 
			}
		});
		
		int[] max = new int[n];
		int[] result = new int[n];
		for(int i=0; i<n; i++) {
			max[i] = comb[i].h;
			result[i] = i;
		}
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(comb[i].l < comb[j].l && comb[i].w < comb[j].w) {
					max[i] = Math.max(max[i], max[j]+comb[i].h);
					result[i] = j;
				}
			}
			if(max[i] > maxHeight) {
				maxHeight = max[i];
			}
		}
		
		return maxHeight;
	}
	private static Box[] getCombinations(Box box) {
		Box[] boxes = new Box[3];
		int max;
		int[] dim = new int[] {box.l, box.w, box.h};
		Arrays.sort(dim);
		boxes[0] = new Box(dim[2], dim[1], dim[0]);
		boxes[1] = new Box(dim[2], dim[0], dim[1]);
		boxes[2] = new Box(dim[1], dim[0], dim[2]);
		return boxes;
	}

}
class Box{
	int l;
	int w;
	int h;
	Box(int l, int w, int h){
		this.l = l;
		this.w = w;
		this.h = h;
	}
	public String toString() {
		return "["+l+","+w+","+h+"]";
	}
}