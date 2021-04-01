import java.util.ArrayList;
import java.util.List;

public class 递增顺序查找树 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    List<TreeNode> list;
    public TreeNode increasingBST(TreeNode root) {
        list=new ArrayList<>();
        if (root==null){
            return null;
        }
        helper(root);
        for (int i=0;i<list.size()-1;i++){
            TreeNode x=list.get(i);
            x.left=null;
            x.right=list.get(i+1);
            if (i==0){
                root=x;
            }
        }
        return root;
    }
    private void helper(TreeNode root) {
        if (root==null){
            return;
        }
        helper(root.left);
        list.add(root);
        helper(root.right);
    }
}
