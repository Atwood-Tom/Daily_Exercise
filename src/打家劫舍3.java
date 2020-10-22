public class 打家劫舍3 {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) { val = x; }
    }
    public int rob(TreeNode root) {
        return Math.max(t(root),f(root));
    }

    private int f(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(t(root.left),f(root.left))+Math.max(t(root.right),f(root.right));
    }

    private int t(TreeNode root) {
        if (root==null){
            return 0;
        }
        return root.val+f(root.left)+f(root.right);
    }
}
