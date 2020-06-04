public class 二叉树的深度 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int max=Math.max(maxDepth(root.left),maxDepth(root.right));
        return max+1;
    }
}
