public class 二叉树的最近公共祖先 {
    //链接:https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    TreeNode Result =null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return null;
        }
        findNode(root,p,q);
        return Result;
    }
    //从root出发，检查能否找到p，q。如果能找到其中一个则返回true，否则返回false
    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return false;
        }
        int x=findNode(root.left,p,q)?1:0;
        int y=findNode(root.right,p,q)? 1:0;
        int z=(p==root||q==root)? 1:0;
        if (x+y+z==2){
            Result =root;
        }
        return x+y+z>0;
    }
}
