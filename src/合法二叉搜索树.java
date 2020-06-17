public class 合法二叉搜索树 {
    //链接:https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return helper(root.left,Long.MIN_VALUE,root.val)&& helper(root.right,root.val,Long.MAX_VALUE);
    }
    private boolean helper(TreeNode root, long min, long max){
        if(root==null) return true;
        if(root.val<=min||root.val>=max) return false;
        return helper(root.left,min,root.val)&& helper(root.right,root.val,max);
    }
}
