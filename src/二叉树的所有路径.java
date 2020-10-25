import java.util.ArrayList;
import java.util.List;

public class 二叉树的所有路径 {
    //链接:https://leetcode-cn.com/problems/binary-tree-paths/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<String> result;
    public List<String> binaryTreePaths(TreeNode root) {
        result=new ArrayList<>();
        if (root==null){
            return result;
        }
        helper(root,"");
        return result;
    }

    private void helper(TreeNode root, String s) {
        s=s+root.val;
        if (root.left==null&&root.right==null){
            result.add(s);
            return;
        }else if (root.left==null&&root.right!=null){
            s=s+"->";
            helper(root.right,s);
        }else if (root.right==null&&root.left!=null){
            s=s+"->";
            helper(root.left,s);
        }else {
            s=s+"->";
            helper(root.left,s);
            helper(root.right,s);
        }
    }
}
