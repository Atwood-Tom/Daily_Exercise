import java.util.List;

public class 检查平衡性 {
    //链接:https://leetcode-cn.com/problems/check-balance-lcci/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean isBalanced(TreeNode root) {
        return Helper(root);
    }

    private boolean Helper(TreeNode root) {
        if (root==null){
            return true;
        }
        int left=Length(root.left);
        int right=Length(root.right);
        if (Math.abs(left-right)>1){
            return false;
        }
        return Helper(root.left)&&Helper(root.right);
    }

    private int Length(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left=Length(root.left)+1;
        int right=Length(root.right)+1;
        return Math.max(left,right);
    }
}
