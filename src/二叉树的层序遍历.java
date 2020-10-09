import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层序遍历 {
    //链接:https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result=new LinkedList<>();
        if (root==null){
            return result;
        }
        Queue<TreeNode> main=new LinkedList<>();
        Queue<TreeNode> help=new LinkedList<>();
        List<Integer> insert=new LinkedList<>();
        main.add(root);
        while(!main.isEmpty()){
            TreeNode node = main.poll();
            if (node.left!=null){
                help.add(node.left);
            }
            if (node.right!=null){
                help.add(node.right);
            }
            insert.add(node.val);
            if (main.isEmpty()){
                main=help;
                help=new LinkedList<>();
                result.add(insert);
                insert=new LinkedList<>();
            }
        }
        return result;
    }
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root){
        result=new LinkedList<>();
        if (root==null){
            return result;
        }
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root, int i) {
        if (result.size()==i){
            result.add(new LinkedList<>());
        }
        result.get(i).add(root.val);
        if (root.left!=null){
            helper(root.left,i+1);
        }
        if (root.right!=null){
            helper(root.right,1+i);
        }
    }
}
