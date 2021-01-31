import java.util.ArrayList;
import java.util.List;

public class 验证二叉搜索树 {
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
    List<Integer> res;
    public boolean isValidBST(TreeNode root) {
        res=new ArrayList<>();
        Solution(root);
        for (int i=0;i+1<res.size();i++){
            if (res.get(i)>res.get(i+1)){
                return false;
            }
        }
        return true;
    }

    private void Solution(TreeNode root) {
        if (root==null){
            return;
        }
        Solution(root.left);
        res.add(root.val);
        Solution(root.right);
    }
}
