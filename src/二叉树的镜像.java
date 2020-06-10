import sun.reflect.generics.tree.Tree;

public class 二叉树的镜像 {
    //链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return root;
        }
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root==null){
            return;
        }
        TreeNode mid=root.left;
        root.left=root.right;
        root.right=mid;
        helper(root.left);
        helper(root.right);
    }
}
