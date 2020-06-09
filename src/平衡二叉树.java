import java.util.HashMap;

public class 平衡二叉树 {
    //链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
    class TreeNode{
        TreeNode right;
        TreeNode left;
        int val;
        TreeNode(int x) { val = x; }
    }
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        return helper(root.left)-helper(root.right)<=1&&helper(root.left)-helper(root.right)>=-1&& isBalanced(root.left)&&isBalanced(root.right);
    }

    private int helper(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(helper(root.left),helper(root.right))+1;
    }
}
