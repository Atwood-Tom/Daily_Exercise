import java.util.LinkedList;
import java.util.Queue;

public class 单值二叉树 {
    //链接:https://leetcode-cn.com/problems/univalued-binary-tree/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    //方法一
    public Queue<Integer> queue=new LinkedList<>();
    public boolean isUnivalTree(TreeNode root) {
        if(root==null){
            return true;
        }
        Helper(root);
        int x=queue.poll();
        while(!queue.isEmpty()){
            if (x!=queue.poll()){
                return false;
            }
        }
        return true;
    }
    private void Helper(TreeNode root) {
        if (root==null){
            return;
        }
        queue.add(root.val);
        Helper(root.left);
        Helper(root.right);
        return;
    }
    //方法二
    public boolean isUnivalTree2(TreeNode root){
        if (root==null){
            return true;
        }
        return Helper2(root);
    }
    private boolean Helper2(TreeNode root){
        if (root==null){
            return true;
        }
        if (root.left!=null&&root.val!=root.left.val){
            return false;
        }
        if (root.right!=null&&root.val!=root.right.val){
            return false;
        }
        return Helper2(root.left)&&Helper2(root.right);
    }
}
