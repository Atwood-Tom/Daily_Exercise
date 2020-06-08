public class 翻转二叉树 {
    //链接:https://leetcode-cn.com/problems/invert-binary-tree/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        Helper(root);
        return root;
    }

    private void Helper(TreeNode root) {
        if (root==null){
            return;
        }
        TreeNode mid=root.left;
        root.left=root.right;
        root.right=mid;
        Helper(root.left);
        Helper(root.right);
    }

}
