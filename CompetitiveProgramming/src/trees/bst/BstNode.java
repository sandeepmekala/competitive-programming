package trees.bst;

class BstNode
 {
     BstNode left, right;
     int data;
 
     public BstNode()
     {
         left = null;
         right = null;
         data = 0;
     }
     public BstNode(int n)
     {
         left = null;
         right = null;
         data = n;
     }
     public void setLeft(BstNode n)
     {
         left = n;
     }
     public void setRight(BstNode n)
     {
         right = n;
     }
     public BstNode getLeft()
     {
         return left;
     }
     public BstNode getRight()
     {
         return right;
     }
     public void setData(int d)
     {
         data = d;
     }
     public int getData()
     {
         return data;
     }     
 }