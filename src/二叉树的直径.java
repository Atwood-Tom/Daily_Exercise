import java.util.List;
//链接:https://leetcode-cn.com/problems/diameter-of-binary-tree/
public class 二叉树的直径 {
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public static int max=0;
      //方法一
    public static int diameterOfBinaryTree2(TreeNode root) {
          max=0;
          find(root);
          return max;
    }
    public static void find(TreeNode root){
        if (root==null){
            return;
        }
        int x=maxDepth(root.left);
        int y=maxDepth(root.right);
        if (x+y>max){
            max=x+y;
        }
        find(root.left);
        find(root.right);
    }
    public  static int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int max=Math.max(maxDepth(root.left),maxDepth(root.right));
        return max+1;
    }
    //方法二
    public static int diameterOfBinaryTree(TreeNode root){
        max=0;
        depth(root);
        return max;
    }

    private  static int  depth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int lefthigh=depth(root.left);
        int righthigh=depth(root.right);
        max=Math.max(lefthigh+righthigh,max);
        return Math.max(lefthigh,righthigh)+1;
    }

    public static void main(String[] args) {
        TreeNode head=new TreeNode(0);
        head.left=new TreeNode(1);
        head.right=new TreeNode(2);
        System.out.println(diameterOfBinaryTree(head));
        System.out.println(diameterOfBinaryTree2(head));
    }
}
