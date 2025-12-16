
import com.algos.topics.models.TreeNode;

public class L99_RecoverBinarySearchTree {
    public static void main(String[] args) {
        L99_RecoverBinarySearchTree obj = new L99_RecoverBinarySearchTree();

        TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        obj.recoverTree(root);
        System.out.println();
    }

    // Proble: https://leetcode.com/problems/recover-binary-search-tree/
    // Time: O(n)
    // space: O(1)
    TreeNode prev=new TreeNode(Integer.MIN_VALUE), first, middle, last;
    public void recoverTree(TreeNode root) {
        inorder(root);
        if(first != null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }else if(first != null && middle != null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    private void inorder(TreeNode root){
        if(root == null)
            return;

        inorder(root.left);
        if(root.val < prev.val){
            if(first == null) { // first vialation
                first = prev;
                middle = root;
            }else{  // second vialation
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
