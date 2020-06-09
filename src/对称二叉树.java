public class 对称二叉树 {
    //链接:https://leetcode-cn.com/problems/symmetric-tree/
    static class TreeNode{
        TreeNode right;
        TreeNode left;
        int val;
        TreeNode(int x) { val = x; }
    }
    public boolean isMirror(TreeNode Lift,TreeNode Right){
        if(Lift==null&&Right==null){
            return true;
        }
        if (Lift==null||Right==null){
            return false;
        }
        if (Lift.val!=Right.val){
            return false;
        }
        return isMirror(Lift.left,Right.right)&&isMirror(Lift.right,Right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return isMirror(root.left,root.right);
    }
}
