import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的右视图 {
    //链接:https://leetcode-cn.com/problems/binary-tree-right-side-view/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<Integer> rightSideView(TreeNode root) {
        if (root==null){
            return new LinkedList<Integer>();
        }
        Deque<TreeNode> helper=new LinkedList<>();
        List<Integer> res=new LinkedList<>();
        List<TreeNode> a=new ArrayList<>();
        helper.addLast(root);
        res.add(root.val);
        while(!helper.isEmpty()){
            TreeNode x=helper.pollFirst();
            if (x.left!=null){
                a.add(x.left);
            }
            if (x.right!=null){
                a.add(x.right);
            }
            if (helper.isEmpty()){
                if (a.size()==0){
                    break;
                }
                res.add(a.get(a.size()-1).val);
                for(TreeNode y:a){
                    helper.addLast(y);
                }
                a=new ArrayList<>();
            }
        }
        return res;
    }
}
