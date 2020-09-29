import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 二叉树的后序遍历 {
    //链接:https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new LinkedList<>();
        if (root==null){
            return result;
        }
        TreeNode x=root;
        Stack<TreeNode> stack=new Stack<>();
        while(x!=null||!stack.isEmpty()){
            while(x!=null){
                stack.push(x);
                x=x.left;
            }
            x=stack.pop();
            if (x.right==null||(result.size() != 0 && result.get(result.size() - 1).equals(x.right.val)) ){
                result.add(x.val);
                x=null;
            }else {
                stack.add(x);
                x=x.right;
            }
        }
        return result;
    }
}
