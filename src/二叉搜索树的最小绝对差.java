import java.util.ArrayList;

public class 二叉搜索树的最小绝对差 {
    //链接:https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    //方法一
    public ArrayList<Integer> arr;
    public int getMinimumDifference1(TreeNode root) {
        if(root==null){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        arr=new ArrayList<>();
        helper(root);
        for (int i=0;i+1<arr.size();i++){
            min=Math.min(min,arr.get(i+1)-arr.get(i));
        }
        return min;
    }

    private void helper(TreeNode root) {
        if (root==null){
            return;
        }
        if (root.left!=null){
            helper(root.left);
        }
        arr.add(root.val);
        if (root.right!=null){
            helper(root.right);
        }
    }
    //方法二
    private int pre = -1;
    private int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pre != -1) {
            result = Integer.min(Math.abs(root.val - pre), result);
        }
        pre = root.val;
        inorder(root.right);
    }
}

