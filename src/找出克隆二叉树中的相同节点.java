public class 找出克隆二叉树中的相同节点 {
    //链接:https://leetcode-cn.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    TreeNode result;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        result=null;
        result=helper(original,cloned,target);
        return result;
    }

    private TreeNode helper(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original==null){
            return original;
        }
        if (original==target){
            return cloned;
        }
        if (original.left!=null){
            TreeNode x=helper(original.left,cloned.left,target);
            if (x!=null){
                return x;
            }
        }
        if (original.right!=null){
            TreeNode x=helper(original.right,cloned.right,target);
            if (x!=null){
                return x;
            }
        }
        return null;
    }
}
