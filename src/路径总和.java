public class 路径总和 {
    //链接:https://leetcode-cn.com/problems/path-sum/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null&&sum==0){
            return false;
        }else if (root==null){
            return false;
        }
        return helper(root,sum);
    }

    private boolean helper(TreeNode root, int sum) {
        sum-=root.val;
        if (root.left==null&&root.right==null){
            if (sum==0){
                return true;
            }else {
                return false;
            }
        }else if (root.left==null&&root.right!=null){
            return helper(root.right,sum);
        }else if (root.left!=null&&root.right==null){
            return helper(root.left,sum);
        }else {
            return helper(root.left,sum)||helper(root.right,sum);
        }
    }
}
