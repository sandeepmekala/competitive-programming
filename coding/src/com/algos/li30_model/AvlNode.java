package  com.algos.li30_model;

public class AvlNode{

	public AvlNode left;
	public AvlNode right;
	public int val;
	public int height = 0;
	
	public AvlNode(int data, int height){
		this.left = null;
		this.right = null;
		this.val = data;
		this.height = height;
	}
	@Override
	public String toString() {
		return "[" + val + "("+height+")]";
	}
}
