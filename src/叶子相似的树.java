import java.util.ArrayList;
import java.util.List;

public class 叶子相似的树 {
    //链接:https://leetcode-cn.com/problems/leaf-similar-trees/
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> result1=new ArrayList<>();
        Helper(root1,result1);
        List<Integer> result2=new ArrayList<>();
        Helper(root2,result2);
        if (result1.size()!=result2.size()){
            return false;
        }
        for (int i=0;i<result1.size();i++){
            if (result1.get(i)!=result2.get(i)){
                return false;
            }
        }
        return true;
    }

    private void Helper(TreeNode root, List<Integer> result) {
        if (root==null){
            return;
        }
        if (root.left!=null){
            Helper(root.left,result);
        }
        if (root.left==null&&root.right==null){
            result.add(root.val);
            return;
        }
        if (root.right!=null){
            Helper(root.right,result);
        }
    }
}
