public class 求根到叶子节点数字之和 {
    //链接:https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int sum;
    public int sumNumbers(TreeNode root) {
        sum=0;
        if (root==null){
            return sum;
        }
        helpecr(root,0);
        return sum;
    }

    private void helpecr(TreeNode root,int step) {
        step*=10;
        step+=root.val;
        if (root.left==null&&root.right==null){
            sum+=step;
            return;
        }else if (root.left==null&&root.right!=null){
            helpecr(root.right,step);
        }else if(root.left!=null&&root.right==null){
            helpecr(root.left,step);
        }else {
            helpecr(root.right,step);
            helpecr(root.left,step);
        }
    }
}
