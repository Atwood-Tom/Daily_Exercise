public class 二叉搜索树的最近公共祖先 {
    //链接:https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    TreeNode result=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return null;
        }
        helper(root,p,q);
        return result;
    }

    private boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return false;
        }
        int x=helper(root.left,p,q)?1:0;
        int y=helper(root.right,p,q)?1:0;
        int z=0;
        if (root==p||root==q) z=1;
        if (x+y+z>=2){
            result=root;
        }
        return x+y+z>0;
    }
}
