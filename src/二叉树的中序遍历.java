import java.util.LinkedList;
import java.util.List;

public class 二叉树的中序遍历 {
    //链接:https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr=new LinkedList<>();
        if (root==null){
            return arr;
        }
        helper(root,arr);
        return arr;
    }

    private void helper(TreeNode root, List<Integer> arr) {
        if (root==null){
            return;
        }
        helper(root.left,arr);
        arr.add(new Integer(root.val));
        helper(root.right,arr);
    }
}
